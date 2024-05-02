select  results from (select name as results ,count from(select user_id , count(*) as count 
from MovieRating
group by user_id) t1 join Users
on t1.user_id = Users.user_id
order by count desc,name
limit 1
) t5

union

select title from (select title,rating
from (select movie_id,avg(rating) as rating
from (select * from MovieRating
where date_format(created_at,'%m-%Y') ='02-2020') t2
group by movie_id
order by rating desc) t3 join Movies
on t3.movie_id=Movies.movie_id
order by rating desc,title
limit 1) t4
