select t4.query_name,round(quality/n,2) as quality,ifnull(round(poor_count/n*100,2),0) as poor_query_percentage
from 
(select query_name,count(*) as poor_count from Queries
where rating<3
group by query_name) as t3 
right outer join 
(select query_name, sum(rating/position) as quality, count(*) as n
from Queries
group by query_name
) 
as t4
on t3.query_name=t4.query_name
