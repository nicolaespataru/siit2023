select 1 + 1;

select *
from orders;


select *
from customers c
where c.name = 'Leibniz Hans';

select c.*, o.*
from customers c
         join orders o on c.id = o.customer_id;
--where c.name = 'Leibniz Hans';

select c.*, o.*
from customers c
         join orders o on c.id = o.customer_id and o."number" = 'From Java Code';

select c.*, o.*
from customers c
         left join orders o on c.id = o.customer_id;

--select c.*, o.*
--from customers c
--right join orders o on c.id = o.customer_id

select c.*, o.*
from orders o
         right join customers c on c.id = o.customer_id;


select *
from orders_products op;

select *
from products p ;

select c."name" , o."number", sum(op.quantity * p.price)
from customers c
         join orders o on o.customer_id = c.id
         join orders_products op on op.order_id = o.id
         join products p on p.id = op.product_id
--where c.name = 'Leibniz Hans' and o."number" = 'FNR98W770'
group by c."name", o."number" ;

select c."name" , o."number", op.quantity ,  p.*
from customers c
         join orders o on o.customer_id = c.id
         join orders_products op on op.order_id = o.id
         join products p on p.id = op.product_id;



SET autocommit=0;
start transaction;

INSERT INTO ORDERS (NUMBER, PLACED, CUSTOMER_ID) VALUES ('From Java Code 10', '1999-7-10 10:20:30', 1);
INSERT INTO ORDERS (NUMBER, PLACED, CUSTOMER_ID) VALUES ('From Java Code 10', '1999-7-10 10:20:30', 1);
INSERT INTO ORDERS (NUMBER, PLACED, CUSTOMER_ID) VALUES ('From Java Code 10', '1999-7-10 10:20:30', 1);
INSERT INTO ORDERS (NUMBER, PLACED, CUSTOMER_ID) VALUES ('From Java Code 10', '1999-7-10 10:20:30', 1);

commit;
OR
rollback;



