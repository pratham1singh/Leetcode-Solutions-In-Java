select product_id,ifnull(round(sum(total)/sum(units),2),0) as average_price
from (select Prices.product_id,Prices.price*UnitsSold.units as total,UnitsSold.units
from Prices left outer join UnitsSold
on (Prices.product_id =UnitsSold.product_id and UnitsSold.purchase_date between Prices.start_date and Prices.end_date )
) as t1
group by product_id