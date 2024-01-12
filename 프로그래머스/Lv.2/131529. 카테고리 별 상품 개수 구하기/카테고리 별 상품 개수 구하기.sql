-- 코드를 입력하세요
SELECT substring(product_code, 1, 2) as category, count(*) as count
from product
group by category
order by product_code;