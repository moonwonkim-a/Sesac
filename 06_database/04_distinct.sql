# DISTINCT (중복 제거)
-- 중복된 값을 제거하고 유니크한(고유한)값들의 목록만 보고 싶을때 사용 // 조회하고싶은 컬럼 앞에다가 사용
-- 특정 컬럼에 어떤 값들이 '종류별로'있는지 확인할 때 유용(중복 제거)
select
	distinct category_code
from
	tbl_menu
order by 
	category_code;
    
-- NULL 값을 포함한 열의 DISTINCT
-- NuLL 도 하나의 값으로 생각하여 중복을 제거한다.
select
	distinct ref_category_code
from
	tbl_category;
    
-- 열이 여러 개인 DISTINCT
-- 지정된 모든 열의 조합이 완전이 똑같을 때만 중복으로 간주하여 제거한다. 두개의열을 하나의 묶음으로 본다.
select distinct
	category_code,
    orderable_status
from
	tbl_menu;