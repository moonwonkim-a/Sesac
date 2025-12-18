#SUBQUERISE(서브쿼리)

-- 1단계 (서브쿼리)
-- 민트미역국의 카테고리 코드를 알아낸다.
select
	category_code
from
	tbl_menu
where
	menu_name = '민트미역국';
    
-- 2단계 (메인 쿼리)
-- '민트미역국과 같은 카테고리의 메뉴 조회'
select
	menu_name,
    category_code
from
	tbl_menu
where
	category_code = (select
						category_code
					from
						tbl_menu
					where
						menu_name = '민트미역국');

-- FROM 절에 서브쿼리 사용
-- 즉석에서 만들어 쓰는 임시 테이블처럼 동작 -> 파생 테이블 이라고도 부른다.

-- "가장 많은 메뉴가 포함된 카테고리는 메뉴를 총 몇 개 가지고 있나요?"

-- 1단계 (서브쿼리) : 카테고리별로 메뉴가 몇 개씩 있는지?
select
	count(*) as 'count'
from 
	tbl_menu
group by
	category_code;

-- 2단계 : 가장 많은 메뉴가 포함된 카테고리의 메뉴 수
select
	max(count) as '최대 메뉴 수'
from
	(select
		 count(*) as 'count'
	 from 
		 tbl_menu
	 group by
		 category_code) as count_table;	-- 파생 테이블은 반드시 별칭이 있어야 한다.
         
-- 상관 서브쿼리(심화과정)
-- 카테고리별 평균 가격보다 높은 가격의 메뉴 조회
select
	avg(menu_price)
from
	tbl_menu
where
	category_code = 4;
    
select
	menu_name,
    menu_price,
    menu_code
from
	tbl_menu a
where menu_price > (select
						avg(menu_price)
					from
						tbl_menu
					where
						category_code = a.category_code);