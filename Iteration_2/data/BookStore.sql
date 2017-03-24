drop database bookstore;
create database bookstore;
use bookstore;

create table user   #用户
	(userID int AUTO_INCREMENT,
	 username varchar(20),
	 password varchar(20),
	 identity varchar(14)
		check(identity in ('admin', 'customer')),
	 mail_address varchar(100),
	 primary key (userID)
	);
	
create table indent    #订单
	(indentID int AUTO_INCREMENT,
	 userID int,
	 amount float,
	 status varchar(14)
		check(status in ('unpay', 'undelivery', 'unconfirm', 'done')),
	 time Date,
	 primary key (indentID),
	 foreign key (userID) references user (userID)
		on delete cascade on update cascade
	);
	
create table book     #书库
	(bookID int AUTO_INCREMENT,
	 price float check(price > 0),
	 quantity int check(quantity >= 0),
	 book_name varchar(50),
	 sales_volume int check(sales_volume>=0),
	 category varchar(1)
		check(category in ('A', 'B', 'C', 'D') ),
	 primary key (bookID)
	);	
	
create table shipment     #订单中的项目
	(bookID int,
	 indentID int,
	 number int check(number > 0),
	 primary key (bookID, indentID),
	 foreign key (bookID) references book (bookID)
		on delete cascade on update cascade,
	 foreign key (indentID) references indent (indentID)
		on delete cascade on update cascade
	);
	
create table book_detail
	(bookID int,
	 author varchar(50),
	 publisher varchar(50),  #出版社
	 primary key (bookID),
	 foreign key (bookID) references book (bookID)
		on delete cascade on update cascade
	);
	
create table user_detail
	(userID int,
	 email varchar(50),
	 ID_number varchar(20),
	 primary key (userID),
	 foreign key (userID) references user (userID)
		on delete cascade on update cascade
	);
	 
create table shopping_cart
	(userID int,
	 bookID int,
	 number int check(number > 0),
	 primary key (bookID, userID),
	 foreign key (bookID) references book (bookID)
		on delete cascade on update cascade,
	 foreign key (userID) references user (userID)
		on delete cascade on update cascade
	);








