select class from (select class , count(student) as cnt from Courses   group by class) as t2
where cnt>=5;