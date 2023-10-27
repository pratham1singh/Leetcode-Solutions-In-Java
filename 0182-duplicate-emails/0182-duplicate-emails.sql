select email from 
(select email, count(id) as cnt from Person group by email) as t1
where cnt>1