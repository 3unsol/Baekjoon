-- 코드를 입력하세요
-- 성분타입별
-- 아이스크림 총 주문량 작은 순서대로
SELECT i.ingredient_type, sum(f.total_order) as total_order
from first_half f
inner join icecream_info i
on f.flavor = i.flavor
group by i.ingredient_type
order by total_order asc;
