-- 코드를 입력하세요
SELECT ao.animal_id, ao.name
from animal_ins ai
join animal_outs ao
on ai.animal_id = ao.animal_id
where ao.datetime is not null
order by datediff(ao.datetime, ai.datetime) DESC
limit 2;