delete from user_detail;
delete from shipment;
delete from indent;
delete from user;
delete from book_detail;
delete from book_stack;

insert into book_stack values ( 1, 1, 10, 'book1');
insert into book_stack values ( 2, 1, 10, 'book2');
insert into book_stack values ( 3, 1, 10, 'book3');
insert into book_stack values ( 4, 1, 10, 'book4');
insert into book_stack values ( 5, 1, 10, 'book5');
insert into book_stack values ( 6, 1, 10, 'book6');
insert into book_stack values ( 7, 1, 10, 'book7');
insert into book_stack values ( 8, 1, 10, 'book8');
insert into book_stack values ( 9, 1, 10, 'book9');
insert into book_detail values ( 1, 'writer1', 'press1','1');
insert into book_detail values ( 2, 'writer2', 'press2','1');
insert into book_detail values ( 3, 'writer3', 'press3','1');
insert into book_detail values ( 4, 'writer4', 'press4','1');
insert into book_detail values ( 5, 'writer5', 'press5','1');
insert into book_detail values ( 6, 'writer6', 'press6','1');
insert into book_detail values ( 7, 'writer7', 'press7','1');
insert into book_detail values ( 8, 'writer8', 'press8','1');
insert into book_detail values ( 9, 'writer9', 'press9','1');
insert into user values ( 'customer1', 'customer1', 'customer', '1', 'customer1', 'customer1', 'address1');
insert into user values ( 'customer2', 'customer2', 'customer', '2', 'customer2', 'customer2', 'address2');
insert into user values ( 'customer3', 'customer3', 'customer', '3', 'customer2', 'customer3', 'address3');
insert into user values ( 'customer4', 'customer4', 'customer', '4', 'customer4', 'customer4', 'address4');
insert into user values ( 'customer5', 'customer5', 'customer', '5', 'customer5', 'customer5', 'address5');
insert into user values ( 'customer6', 'customer6', 'customer', '6', 'customer6', 'customer6', 'address6');
insert into user values ( 'customer7', 'customer7', 'customer', '7', 'customer7', 'customer7', 'address7');
insert into user values ( 'customer8', 'customer8', 'customer', '8', 'customer8', 'customer8', 'address8');
insert into user values ( 'customer9', 'customer9', 'customer', '9', 'customer9', 'customer9', 'address9');
insert into user values ( 'admin', 'admin', 'admin', '0', 'admin', 'admin', 'address0');
insert into indent values ( 1, 'customer1', 2);
insert into indent values ( 2, 'customer2', 2);
insert into indent values ( 3, 'customer3', 2);
insert into indent values ( 4, 'customer4', 2);
insert into indent values ( 5, 'customer5', 2);
insert into indent values ( 6, 'customer6', 2);
insert into indent values ( 7, 'customer7', 2);
insert into indent values ( 8, 'customer8', 2);
insert into indent values ( 9, 'customer9', 2);
insert into indent values ( 11, 'customer1', 2);
insert into indent values ( 12, 'customer2', 2);
insert into indent values ( 13, 'customer3', 2);
insert into indent values ( 14, 'customer4', 2);
insert into indent values ( 15, 'customer5', 2);
insert into indent values ( 16, 'customer6', 2);
insert into indent values ( 17, 'customer7', 2);
insert into indent values ( 18, 'customer8', 2);
insert into indent values ( 19, 'customer9', 2);
insert into shipment values ( 1, 1, 1);
insert into shipment values ( 2, 1, 1);
insert into shipment values ( 1, 2, 1);
insert into shipment values ( 6, 2, 1);
insert into shipment values ( 1, 3, 1);
insert into shipment values ( 7, 3, 1);
insert into shipment values ( 6, 4, 1);
insert into shipment values ( 1, 4, 1);
insert into shipment values ( 5, 5, 1);
insert into shipment values ( 2, 5, 1);
insert into shipment values ( 1, 6, 1);
insert into shipment values ( 5, 6, 1);
insert into shipment values ( 2, 7, 1);
insert into shipment values ( 6, 7, 1);
insert into shipment values ( 7, 8, 1);
insert into shipment values ( 9, 8, 1);
insert into shipment values ( 2, 9, 1);
insert into shipment values ( 1, 9, 1);
insert into shipment values ( 5, 11, 1);
insert into shipment values ( 9, 11, 1);
insert into shipment values ( 2, 12, 1);
insert into shipment values ( 6, 12, 1);
insert into shipment values ( 1, 13, 1);
insert into shipment values ( 7, 13, 1);
insert into shipment values ( 6, 14, 1);
insert into shipment values ( 1, 14, 1);
insert into shipment values ( 5, 15, 1);
insert into shipment values ( 2, 15, 1);
insert into shipment values ( 1, 16, 1);
insert into shipment values ( 5, 16, 1);
insert into shipment values ( 2, 17, 1);
insert into shipment values ( 6, 17, 1);
insert into shipment values ( 7, 18, 1);
insert into shipment values ( 9, 18, 1);
insert into shipment values ( 2, 19, 1);
insert into shipment values ( 1, 19, 1);
insert into user_detail values ( 'customer1', 'email1@qq.com', '330521000000000001', '1');
insert into user_detail values ( 'customer2', 'email2@qq.com', '330521000000000002', '1');
insert into user_detail values ( 'customer3', 'email3@qq.com', '330521000000000003', '1');
insert into user_detail values ( 'customer4', 'email4@qq.com', '330521000000000004', '1');
insert into user_detail values ( 'customer5', 'email5@qq.com', '330521000000000005', '1');
insert into user_detail values ( 'customer6', 'email6@qq.com', '330521000000000006', '1');
insert into user_detail values ( 'customer7', 'email7@qq.com', '330521000000000007', '1');
insert into user_detail values ( 'customer8', 'email8@qq.com', '330521000000000008', '1');
insert into user_detail values ( 'customer9', 'email9@qq.com', '330521000000000009', '1');
insert into user_detail values ( 'admin', 'email0@qq.com', '330521000000000000', '1');