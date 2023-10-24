select customer_id from 
(select customer_id,count( distinct product_key) as cnt from Customer group by customer_id)
as t1 where cnt= (select count(product_key) from Product);