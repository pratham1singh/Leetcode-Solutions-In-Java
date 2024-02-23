select name from
Employee join 
(select managerId,count(*) as c from 
Employee group by managerId) as t2
on Employee.id=t2.managerId
where c>=5
