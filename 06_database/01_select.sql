#SELECT
--SELECT 컬럼명 FROM 테이블병
-- 특정 테이블에서 원하는 데이터를 조회하는데 사용

-- 단일 열(컬럼) 데이터 검색
select menu_name from tbl_menu;

-- 여러 열의 데이터 검색
select 
	menu_code,
    menu_name,
    menu_price
from
	tbl_meni;
    
-- 모든 열에서 데이터 검색(* : 모든 컬럼을 의미하는 와일드 카드)
select
	*
from
	tbl_menu;
    
-- FROM절 없이 단순 테스트를 위해 사용 할 수 있다.
-- 간단한 연산
select 6 + 3;
select 6 * 3;

-- 내장 함수 사용
select now(); -- 현재 날짜와 시간을 보여준다.
select concat('홍','길동');	-- 여러 문자열을 합쳐준다.

-- 컬럼 별칭(Alias) 사용
select concat('홍','길동') as name;