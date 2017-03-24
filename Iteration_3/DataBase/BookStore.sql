drop database bookstore;
create database bookstore;
use bookstore;

create table User   #用户
	(UserID int AUTO_INCREMENT,
	 UserName varchar(20),
	 Password varchar(20),
	 Identity varchar(14)
		check(identity in ('admin', 'customer')),
	 MailAddress varchar(100),
	 primary key (UserID)
	);
	
create table Indent    #订单
	(OrderID int AUTO_INCREMENT,
	 UserID int,
	 Amount float,
	 Status varchar(14)
		check(status in ('unpay', 'undelivery', 'unconfirm', 'done')),
	 Time date,
	 primary key (OrderID),
	 foreign key (UserID) references User (UserID)
		on delete cascade on update cascade
	);
	
create table Book     #书库
	(BookID int AUTO_INCREMENT,
	 Price float check(Price > 0),
	 Quantity int check(Quantity >= 0),
	 BookName varchar(50),
	 SalesVolume int check(SalesVolume>=0),
	 Category varchar(1)
		check(Category in ('A', 'B', 'C', 'D') ),
	 primary key (BookID)
	);	
	
create table OrderItem     #订单中的项目
	(OrderItemID int AUTO_INCREMENT,
	 BookID int,
	 OrderID int,
	 Number int check(number > 0),
	 TotalPrice float check(total_price > 0),
	 primary key (OrderItemID),
	 foreign key (BookID) references Book (BookID)
		on delete cascade on update cascade,
	 foreign key (OrderID) references Indent (OrderID)
		on delete cascade on update cascade
	);
	
create table BookDetail
	(BookID int,
	 Author varchar(50),
	 Publisher varchar(50),  #出版社
	 Photo varchar(100),
	 Video varchar(100),
	 primary key (BookID),
	 foreign key (BookID) references Book (BookID)
		on delete cascade on update cascade
	);
	
create table UserDetail
	(UserID int,
	 Email varchar(50),
	 ID_number varchar(20),
	 Photo varchar(100),
	 Video varchar(100),
	 primary key (UserID),
	 foreign key (UserID) references User (UserID)
		on delete cascade on update cascade
	);
	
create table CartItem
	(CartItemID int AUTO_INCREMENT,
	 UserID int,
	 BookID int,
	 Number int check(Number > 0),
	 TotalPrice float check(TotalPrice > 0),
	 primary key (CartItemID),
	 foreign key (BookID) references Book (BookID)
		on delete cascade on update cascade,
	 foreign key (UserID) references User (UserID)
		on delete cascade on update cascade
	);


create trigger update_totalPrice_In_CartItem after update of Number on CartItem
	referencing new row as nrow
	for each row
		declare bookPrice int;
		
		select Price into bookPrice
		from Book
		where BookID = nrow.BookID;
		
		update CartItem
		set TotalPrice = bookPrice * nrow.Nunmber
		where CartItemID = nrow.CartItemID;
		
	end;
	
	

create trigger update_quantity_and_salesVolume after update of Status on Indent
	referencing new row as nrow
	referencing old row as orow
	for each row
		when(nrow.Status = "undelivery" and orow.Status = "unpay")
		begin
			declare cur cursor for 
				select BookID, Number form OrderItem where OrderID = nrow.OrderID;
			
			declare bookID int;
			declare number int;
			
			open cur;
				repeat
					fetch cur into bookID, number;
					update Book
					set Quantity = Quantity - number, 
						SalesVolume = SalesVolume + number 
					where BookID = bookID;
				end repeat;
			close cur;
		end;
	end;	
	
						
create trigger update_amount_of_order after insert on Indent
	referencing new row as nrow
	for each row
		declare cur cursor for 
			select TotalPrice form OrderItem where OrderID = nrow.OrderID;
			
		declare totalPrice float;
		declare amount float;
		set amount = 0;
		open cur;
			repeat
				amount = amount + totalPrice;
			end repeat;
		close cur;
		
		update Indent
		set Amount = amount
		where OrderID = nrow.OrderID;
	end;	

	
create function check_quantity ( orderID int)
returns boolean
begin
	declare cur cursor for 
		select BookID, Number form OrderItem where OrderID = orderID;
			
	declare ans boolean;
	declare quantity int;
			
	open cur;
		repeat
			fetch cur into bookID, number;
			select Quantity into quantity
			from Book
			where BookID = bookID;
			if quantity < number
			then ans = false
			end if;
		end repeat;
	close cur;
	return ans;
end;
	


create function find_all_order_with_a_book (bookID int)
return table (OrderID int)
begin
	create temporary table temp (OrderID int);
	
	insert into temp
		select OrderID
		from OrderItem
		where BookID = bookID;
		
	return table temp;
end;




create function total_amount (table orders ( OrderID int))
return sum float
begin
	declare cur cursor for orders;
	declare orderID int;
	declare amount float;
	declare sum float;
	
	set sum = 0;
	open cur;
		repeat
			fetch cur into orderID;
			select Amount into amount
			from Indent
			where OrderID = orderID;
			sum = sum + amount;
		end repeat;
	close cur;
	return sum;
end;


create function find_all_order_with_a_book_category (category varchar(1))
return table (OrderID int)
begin
	create temporary table temp (OrderID int);
	
	declare cur cursor for 
		select BookID, OrderID form OrderItem;
	declare bookID int;
	declare orderID int;
	declare bc varchar(1);
	
	open cur;
		repeat
			fetch cur into bookID, orderID;
			
			select Category into bc
			from Book
			where BookID = bookID;
			
			if(bc = category)
			then insert into temp orderID;
			end if
		end repeat;
	close cur;
	
	return table temp;
end;



create function find_all_order_of_a_customer (userID int)
return table (OrderID int)
begin
	create temporary table temp (OrderID int);
	
	insert into temp
		select OrderID
		from Order
		where UserID = userID;
		
	return table temp;
end;
