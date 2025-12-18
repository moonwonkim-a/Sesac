#JOIN

-- 1. 컬럼 별칭
select
	menu_name as '메뉴 이름',	-- 띄어쓰기가 있으니 따옴표 사용
    menu_price				-- 간단하면 AS와 따옴표 생략 가능
from
	tbl_menu;
    
-- 2. 테이블 별칭 (JOIN에서 필수)
-- tbl_menu 테이블에 'a'라는 별칭을 붙여줌
select
	a.menu_name,
    a.menu-price
from
	tbl_menu as a;	-- AS 생략 가능
    
-- INNER JOIN - 교집합 (가장 기본적인 조인, INNER 키워드 생략 가능)
select
	a.menu_name,	-- a talbe의 menu_name
    b.category_name	-- b table의 category_name
from
	tbl_menu a	-- AS 생략
inner join tbl_category b on a.category_code = b.category_code;

-- OUTER JOIN(LEFT/RIGHT)
-- LEFT JOIN : JOIN구문을 기준으로 왼쪽 테이블의 데이터는 모두 보여주고,
-- 		       오른쪽 테이블에서 짝이 맞는 데이터가 없으면 'NULL'로 채줘서 보여준다.
select
	a.category_name,
    b.menu_name
from
	tbl_category a -- 왼쪽 테이블
left join tbl_menu b on a.category_code = b.category_code;

-- SELF JOIN(같은 테이블 안에서 행과 행의 관계가 있는 경우, 그걸 연결해서 보고 싶을 때 셀프조인을 할 수 있다.)
select
	a.category_name as '하위 카테고리',
    b.category_name as '상위 카테고리'
from
	tbl_category a -- '하위' 역할을 할 a 테이블
join tbl_category b on a.ref_category_code = b.category_code -- '상위' 역할을 할 b 테이블