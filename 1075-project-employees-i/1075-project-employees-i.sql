select project_id,round(sum(experience_years) /count(*),2) as average_years
from (select Project.project_id,Employee.experience_years
from Project join Employee
on (Project.employee_id=Employee.employee_id)) as t1
group by project_id;