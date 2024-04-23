
select name as 'Department', Ename as 'Employee', salary as Salary
from (select departmentId,name as Ename,salary,dense_rank() over (partition by departmentId order by salary desc) as 'ranking'
from Employee) newTable join Department
on newTable.departmentId=Department.id
where ranking in (1,2,3)