# SET OPERATORS(집합 연산자)

-- UNION : 두 결과를 합치기(중복은 제거 -> 합집합)
-- 카테고리 코드가 10번인 메뉴들
-- 가격이 9,000원 미만인 메뉴들

select
	menu_name,
    menu_price,
    category_code
from
	tbl_menu
where
	category_code = 10
union	-- 두 결과를 합친다.( 중복은 제거하고 )
select
	menu_name,
    menu_price,
    category_code
from
	tbl_menu
where
	menu_price < 9000;
    
-- UNION ALL : 두 결과를 그냥 다 합치기(중복 포함)
select
	menu_name,
    menu_price,
    category_code
from
	tbl_menu
where
	category_code = 10
union all 	-- 두 결과 합치기 ( 중복 포함 )
select
	menu_name,
    menu_price,
    category_code
from
	tbl_menu
where
	menu_price < 9000;
    
/* INTERSECT */
-- MySQL은 INTERSECT를 제공하지 않는다. 하지만 INNER JOIN 또는 IN을 활용해서 구현하는 것은 가능하다.

-- 1) INNER JOIN 활용
SELECT 
    a.menu_code,
    a.menu_name,
    a.menu_price,
    a.category_code,
    a.orderable_status
FROM
    tbl_menu a
INNER JOIN (SELECT 
		menu_code,
		menu_name,
		menu_price,
		category_code,
		orderable_status
	FROM
		tbl_menu 
	WHERE
		menu_price < 9000) b on (a.menu_code = b.menu_code)
WHERE
    a.category_code = 10;
    
-- 2) IN 연산자 활용
SELECT 
    menu_code,
    menu_name,
    menu_price,
    category_code,
    orderable_status
FROM
    tbl_menu
WHERE
    category_code = 10 AND
    menu_code IN (SELECT 
		menu_code
	FROM
		tbl_menu 
	WHERE
		menu_price < 9000);

/* MINUS */
-- MySQL은 MINUS를 제공하지 않는다. 하지만 LEFT JOIN을 활용해서 구현하는 것은 가능하다.
SELECT 
    a.menu_code,
    a.menu_name,
    a.menu_price,
    a.category_code,
    a.orderable_status
FROM
    tbl_menu a
LEFT JOIN (SELECT 
		menu_code,
		menu_name,
		menu_price,
		category_code,
		orderable_status
	FROM
		tbl_menu 
	WHERE
		menu_price < 9000) b on (a.menu_code = b.menu_code)
WHERE
    a.category_code = 10 AND
    b.menu_code IS NULL;