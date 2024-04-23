with newTable as (select departmentId,salary,name as Ename ,rank()
over (partition by departmentId order by salary desc) as r
from Employee)

select name as Department, Ename as Employee , salary as Salary
from (select departmentId,Ename,salary from newTable
where r=1) finalTable join Department
on finalTable.departmentId=Department.id