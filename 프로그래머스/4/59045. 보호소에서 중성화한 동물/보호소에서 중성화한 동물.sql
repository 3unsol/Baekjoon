-- 코드를 입력하세요
SELECT ao.animal_id, ao.animal_type, ao.name
from animal_outs ao
join animal_ins ai
on ao.animal_id = ai.animal_id
where ai.sex_upon_intake like "Intact%"
and ao.sex_upon_outcome not like "Intact%"
order by ao.animal_id;