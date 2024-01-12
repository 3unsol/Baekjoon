-- 코드를 입력하세요
-- 5월 1일 출고완료 / 이후 : 출고 대기 / 미정 : 출고미정
-- 주문ID 오름차순
SELECT order_id, product_id, date_format(out_date, '%Y-%m-%d') as out_date, 
case when out_date <= '2022-05-01' then "출고완료" 
when out_date > '2022-05-01' then "출고대기" 
else "출고미정" end as 출고여부
from food_order
order by order_id;
