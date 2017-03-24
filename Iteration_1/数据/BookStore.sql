drop database bookstore;
create database bookstore;
use bookstore;

create table user
	(username varchar(20),
	 password varchar(20),
	 identity varchar(14)
		check(identity in ('admin', 'customer')),
	 id varchar(20),
	 authKey varchar(20),
	 accessToken varchar(20),
	 mail_address varchar(100),
	 primary key (username)
	);
	
create table indent
	(indentID numeric(38,0),
	 username varchar(20),
	 amount numeric(38,2),
	 primary key (indentID),
	 foreign key (username) references user (username)
		on delete cascade on update cascade
	);
	
create table book_stack
	(bookID numeric(38,0),
	 price numeric(38,2) check(price > 0),
	 quantity numeric(38,0) check(quantity >= 0),
	 book_name varchar(50),
	 primary key (bookID)
	);	
	
create table shipment
	(bookID numeric(38,0),
	 indentID numeric(38,0),
	 number numeric(38,0) check(number > 0),
	 primary key (bookID, indentID),
	 foreign key (bookID) references book_stack (bookID)
		on delete cascade on update cascade,
	 foreign key (indentID) references indent (indentID)
		on delete cascade on update cascade
	);
	
create table book_detail
	(bookID numeric(38,0),
	 writer varchar(50),
	 press varchar(50),
	 picture varchar(1),
	 primary key (bookID),
	 foreign key (bookID) references book_stack (bookID)
		on delete cascade on update cascade
	);
	
create table user_detail
	(username varchar(20),
	 email varchar(50),
	 ID_number varchar(20),
	 photo varchar(1),
	 primary key (username),
	 foreign key (username) references user (username)
		on delete cascade on update cascade
	);
	 









