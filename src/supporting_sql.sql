-- we only included complex SQL commands in this file as simple SQL
-- such as (select * from ________) or (insert into ________ values(...))
-- is fairly straightforward and can be easily seen from our ____Ora classes.


-- create view for Transactions join Product
create view trans_upon_product as
       select upon.tid, Transactions.tamount, Transactions.tday, Transactions.ttime, Transactions.cid, Transactions.eid,
              upon.ptype, Product.price, Product.stockAmount, Product.returnableFlag
       from Transactions
       join upon on upon.tid = Transactions.tid
       join Product on upon.ptype = Product.ptype;


create view trans_upon_product as select upon.tid, Transactions.tamount, Transactions.tday, Transactions.ttime, Transactions.cid, Transactions.eid, upon.ptype, Product.price, Product.stockAmount, Product.returnableFlag from Transactions join upon on upon.tid = Transactions.tid join Product on upon.ptype = Product.ptype;


-- group transactions by ptype
select select sum(tamount), ptype
from trans_upon_prod
group by ptype;


-- drop trans_upon_product view
drop view trans_upon_product;


-- create view for Transactions join Employee
create view trans_input_empl as
       select Employee.ename, Employee.eid, Employee.position, Employee.tier, Employee.mmid,
              Transactions.tid, Transactions.tamount, Transactions.tday, Transactions.ttime, Transactions.cid
       from Employee
       join Transactions on Employee.eid = Transactions.eid;


-- drop trans_input_empl view
drop view trans_input_empl;


-- get Transactions made by Employee e between the dates from and to
select tid, tday, ttime, cid, eid
from trans_input_empl
where ( tday between from and to ) and eid = e;


-- join Product, Supplier, Manager, and track
select Supplier.sname, track.sphone,
       Product.ptype, Product.price, Product.stockAmount, Product.returnableFlag,
       track.mmid, Manager.mname
from Product
join track on track.ptype = Product.ptype
join Supplier on Supplier.sphone = track.sphone
join Manager on Manager.mmid = track.mmid;
