-- 코드를 입력하세요
-- 입양갔는지 확인
-- 보호 기간 가장 길었던 동물 두 마리
-- 보호 기간 긴 순서
SELECT ao.animal_id, ao.name
from animal_outs ao
inner join animal_ins ai
on ao.animal_id = ai.animal_id
order by datediff(ao.datetime, ai.datetime) + 1 desc
limit 2;