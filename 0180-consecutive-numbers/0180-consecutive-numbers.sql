select  distinct t4.num as ConsecutiveNums
from (select t2.id,t1.num
from Logs t1 join Logs t2
on t1.num=t2.num and t1.id=t2.id-1) t3 
join Logs t4
on t3.id=t4.id-1 and t3.num=t4.num