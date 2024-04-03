# Write your MySQL query statement below
select  t2.month,t2.country,t3.trans_count, t2.approved_count,t3.trans_total_amount, t2.approved_total_amount
from (select date_format(trans_date,"%Y-%m") as month,country,count(*) as approved_count,sum(amount) as approved_total_amount
from (select * from Transactions
where state = "approved") as t1
group by country,date_format(trans_date,"%Y-%m")) t2
join (select date_format(trans_date,"%Y-%m") as month,country,count(*) as trans_count,sum(amount) as trans_total_amount
from Transactions as t1
group by country,date_format(trans_date,"%Y-%m")) t3
on t2.month=t3.month and t2.country=t3.country;