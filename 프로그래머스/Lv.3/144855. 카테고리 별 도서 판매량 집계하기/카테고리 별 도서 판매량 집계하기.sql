-- 코드를 입력하세요
# SELECT b.category
select b.category, sum(bs.sales) as total_sales
from book b
left join book_sales bs
on b.book_id = bs.book_id
where date_format(bs.sales_date, '%Y-%m') = '2022-01'
group by b.category
order by b.category;