# GROUP BY
-- 지정된 컬럼의 값이 같은 데이터들을 하나의 그룹으로 묶어라

select
	category_code
from
	tbl_menu
group by
	category_code;
    
-- COUNT() : 각 그룹에 속한 행의 개수를 센다.
select
	category_code,
    count(*) as '메뉴 개수'
from
	tbl_menu
group by
	category_code;
    
select
	category_code,
    -- menu_code,	-- 주의사항 :GROUP BY를 사용할 때, GROUP BY에 사용된 컬럼과 집계 함수만 올 수 있다.
    sum(menu_price) as '가격 총합',
    avg(menu_price) as '가격 평균'
from
	tbl_menu
group by
	category_code;
    
-- HAVING : 그룹에 대한 조건 필터링	(WHERE랑 햇갈림 주의. where는 그룹화 전)
select
	category_code,
    count(*) as '메뉴 개수'
from
	tbl_menu
group by
	category_code
having
	count(*) >= 3;	-- 그룹화 된 결과(메뉴 개수)가 3개 이상인 그룹만 필터링
-- 작성 순서 : FROM -> WHERE -> GROUP BY -> HAVING -> ORDER BY

-- ROLLUP(그룹별 집계 결과와 함께 그 그룹들의 소계와 총계를 보여줌)
select
	category_code,
    sum(menu_price)
from
	tbl_menu
group by
	category_code
with rollup;

-- 가격대별, 그 안에서 카테고리별로 그룹화 하고 ROLLUP 적용
select
	menu_price,
    category_code,
    sum(menu_price)
from
	tbl_menu
group by
	menu_price,
    category_code
with rollup;