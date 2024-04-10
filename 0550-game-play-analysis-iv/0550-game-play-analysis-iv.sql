select round(count(*)/(select sum(a)
from (select player_id, 1 as a
from Activity
group by player_id
) t2),2) as fraction
from
(select player_id,min(event_date) as firstDay
from Activity
group by player_id) as t1
join Activity
on Activity.player_id=t1.player_id and Activity.event_date=t1.firstDay+1


