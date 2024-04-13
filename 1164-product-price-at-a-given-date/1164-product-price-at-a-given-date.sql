select t4.product_id,ifnull(t3.new_price,10) as price
from (select t2.product_id,Products.new_price
from (select product_id,max(change_date) as change_date
from (select *
from Products
where change_date<="2019-08-16") t1
group by product_id) t2 join Products
on t2.product_id=Products.product_id and t2.change_date=Products.change_date
) t3 right outer join 
(select  distinct product_id from Products) t4
on t3.product_id=t4.product_id