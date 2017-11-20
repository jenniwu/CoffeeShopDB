-- create database CoffeshopDB_xxxx;
-- go

-- use CoffeshopDB_xxxx;
-- go
drop table track;
-- cascade delete from Manager, Product and Supplier
drop table upon;
-- cascade delete from Transactions and Product
drop table makes;
-- has no dependencies
drop table Transactions;
--cascade delete from Customer and Employee
drop table Customer;
--cascade delete from Vip
drop table Vip;
-- cascade delete from Employee
drop table Employee;
-- cascade delete from Salary and Manager
drop table Salary;
-- has no dependencies
drop table Manager;
-- has no dependencies
drop table Supplier;
-- has no dependencies
drop table Product;
-- has no dependencies

commit;

create table Product
  (price int not null,
  stockAmount int not null,
  returnableFlag varchar(10) not null,
  ptype varchar(30) not null,
  primary key (ptype));
grant select on Product to public;




create table Supplier
  (sphone char(20) not null,
  sname varchar(30) not null,
  primary key (sphone));
grant select on Supplier to public;




create table Manager
  (mmid int not null,
  mname varchar(30) not null,
  primary key (mmid));
grant select on Manager to public;



create table Salary
  (tier int not null,
  frequency varchar(30) not null,
  bonus int not null,
  primary key (tier));
grant select on Salary to public;



create table Employee
  (eid int not null,
  ename varchar(40) not null,
  position varchar(30) not null,
  tier int not null,
  mmid int not null,
  primary key (eid),
  foreign key (tier) references Salary ON DELETE CASCADE,
  foreign key (mmid) references Manager ON DELETE SET NULL);
grant select on Employee to public;



create table Vip
  (phone char(20) not null,
  email varchar(40) not null,
  loyaltyPoints int not null,
  birthday date not null,
  dollarBalance int,
  eid int,
  primary key (phone),
  foreign key (eid) references Employee ON DELETE CASCADE);
grant select on Vip to public;



create table Customer
  (cid int not null,
  cname varchar(30) not null,
  phone char(20) not null,
  primary key (cid),
  foreign key (phone) references Vip ON DELETE CASCADE);
grant select on Customer to public;



create table Transactions
  (tid int not null,
  tamount int not null,
  tday date not null,
  ttime varchar(30) not null,
  cid int not null,
  eid int not null,
  primary key (tid),
  foreign key (cid) references Customer ON DELETE SET NULL,
  foreign key (eid) references Employee ON DELETE SET NULL);
grant select on Transactions to public;



create table makes
  (rating int not null);
grant select on makes to public;



create table upon
  (tid int not null,
  ptype varchar(30) not null,
  primary key (tid, ptype),
  foreign key (tid) references Transactions ON DELETE CASCADE,
  foreign key (ptype) references Product ON DELETE SET NULL);
grant select on upon to public;



create table track
  (ptype varchar(30) not null,
  sphone char(20) not null,
  mmid int not null,
  primary key (ptype, sphone, mmid),
  foreign key (mmid) references Manager ON DELETE SET NULL,
  foreign key (ptype) references Product ON DELETE CASCADE,
  foreign key (sphone) references Supplier ON DELETE SET NULL);
grant select on track to public;
commit;







-- insert data into diffrent tables

insert into Product values
--(price,stockamount,return?,ptype)
(20, 10, 'NO', 'coffee');
insert into Product values
(150, 10, 'YES', 'coffee beans');
insert into Product values
(5, 50, 'YES', 'coffee machine');


insert into Supplier values
--(sphone,sname)
('778-893-3079', 'Swagger');
insert into Supplier values
('778-803-5783', 'Malcom');
insert into Supplier values
('778-093-2761', 'Jacob');


insert into Manager values
--(mmid,mname)
(123, 'Knorr');
insert into Manager values
(206, 'Mike');


insert into Salary values
--(tier, frequency, bonus)
(1, 'monthly', 100);
insert into Salary values
(2, 'weekly', 50);
insert into Salary values
(3, 'monthly', 0);


insert into Employee values
--(eid,ename,position,tier,emid)
(1234, 'A', 'sales clerk', 1, 123);
insert into Employee values
(2234, 'B', 'skilled worker', 1, 123);
insert into Employee values
(8265, 'C', 'dustman', 3, 206);


insert into Vip values
--(phone, email, loyaltypoints,birthday,dollarbalance,eid)
('778-681-4862','anna@gmail.com', 21, '1996-1-11', 100, 1234);
insert into Vip values
('778-674-5692','ben@gmail.com', 50, '1995-1-21', 10, 2234);
insert into Vip values
('778-294-3298','chris@gmail.com', 266, '1988-10-1', 200, 8265);


insert into Customer values
--(cid,cname,phone)
(1, 'A. Anna', '778-681-4862');
insert into Customer values
(2, 'B. Ben', '778-674-5692');
insert into Customer values
(3, 'C. Chris', '778-294-3298');
insert into Customer values
(4, 'D. Dennis', '778-123-1342');
insert into Customer values
(5, 'E. Eddie', '778-456-5635');
insert into Customer values
(6, 'F. Frank', '778-723-0985');
insert into Customer values
(7, 'G. Ganster', '778-522-0784');
insert into Customer values
(8, 'H. Henry', '778-678-3985');
insert into Customer values
(9, 'I. Iris', '778-990-6784');
insert into Customer values
(10, 'J. Jenny', '778-255-0275');
insert into Customer values
(11, 'K. Kanye', '778-670-9065');
insert into Customer values
(12, 'L. Leonaldo', '778-359-8391');
insert into Customer values
(13, 'M. Mundo', '778-782-1298');
insert into Customer values
(14, 'N. Natasha', '778-091-1234');
insert into Customer values
(15, 'O. Oliver', '778-123-2345');


insert into Transactions values
--(tid,tamount,tday,ttime,cid,eid)
(12345, 20, '2017-11-15', '20:20:20',1,1234);
insert into Transactions values
(23456, 5, '2017-11-02', '18:30:00',2,2234);
insert into Transactions values
(67821, 50, '2017-08-15', '23:08:36',3,8265);
insert into Transactions values
(85310, 50, '2017-08-19', '21:38:46',1,2234);


insert into makes values
--(rating)
(10);
insert into makes values
(6);
insert into makes values
(5);


insert into upon values
--(tid,ptype)
(12345,'coffee');
insert into upon values
(23456,'coffee beans' );
insert into upon values
(67821,'coffee machine');
insert into upon values
(85310,'coffee machine');

insert into track values
--(ptype,sphone,mmid)
('coffee','778-893-3079',123);
insert into track values
('coffee beans','778-893-3079',123);
insert into track values
('coffee machine','778-803-5783',206);
