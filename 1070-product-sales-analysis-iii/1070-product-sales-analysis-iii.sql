select product_id,min(year) as first_year, quantity,price
from (select P.product_id,price,quantity,year
from Product P join 
Sales S on P.product_id=S.product_id) t1
group by P.product_id
