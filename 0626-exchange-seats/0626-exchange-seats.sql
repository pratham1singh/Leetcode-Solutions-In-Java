select *
from 
(select t1_id as id,t1_student as student from (select rank() over(order by t3.t1_id) as sn,t1_id,t1_student
from (select t1.id as "t1_id",t2.student as 't1_student',t2.id as "t2_id",t1.student as 't2_student'
from Seat t1 left outer join Seat t2
on t1.id=t2.id-1) t3) t4
where sn mod 2 <>0
union
select t2_id as id,t2_student as student from (select rank() over(order by t3.t1_id) as sn,t2_id,t2_student
from (select t1.id as "t1_id",t2.student as 't1_student',ifnull(t2.id,t1.id) as "t2_id",t1.student as 't2_student'
from Seat t1 left outer join Seat t2
on t1.id=t2.id-1) t3) t4
where sn mod 2 <>0) t5
where not student is null
order by id

-- select t1.id as "t1_id",t2.student as 't1_student',t2.id as "t2_id",t1.student as 't2_student'
-- from Seat t1 left outer join Seat t2
-- on t1.id=t2.id-1