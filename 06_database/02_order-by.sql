#ORDER BY 컬럼명
-- SELECT문의 가장 마지막에 위치하며, 결과 집합을 하나의 열로 정렬

-- 오름차순 정렬
select
	menu_code,
    menu_name,
    menu_price
from
	tbl_menu
order by
	-- menu_price asc; -- ASC는 오름차순을 의미 (디폴트 값이라서 생략 가능)
    menu_price;

-- 내림차순 정렬
select
	menu_code,
    menu_name,
    menu_price
from
	tbl_menu
order by
    menu_price desc, -- DESC는 내림차순
    menu_name ASC;	-- 2차 기준 : 가격이 같다면, 이름 오름차순으로
    
-- 연산 결과로 정렬 (보통 별칭을 사용한다)
select
	menu_code,
    menu_price,
    menu_code * menu_price as calculated_value
from
	tbl_menu
order by
	calculated_value desc;
    
-- FIELD(컬럼, 첫번째, 두번째, ...) : 컬럼 값이 목록의 몇 번째에 있는지 숫자로 알려준다.
select field('b','a','b','c');

-- 'N'을 1tansd, 'Y'를 2순위로 결정
select
	menu_name,
    orderable_status
from
	tbl_menu
order by field(orderable_status,'N','Y');	-- N은 1, Y는 2가 되어 이 결과를 기준으로 오름차순 정렬

-- null 값이 있는 컬럼에 대한 정렬 (MYSQL은 null을 가장 작은 값으로 취급한다.)
select
	category_code,
    category_name,
    ref_category_code
from
	tbl_category
order by
	ref_category_code is null;	-- null 이면 true(1), 아니면 false(0) 반환

-- 내림차순 시 null을 처음으로(is null desc)
select
	category_code,
    category_name,
    ref_category_code
from
	tbl_category
order by
	ref_category_code is null desc,
    ref_category_code desc;