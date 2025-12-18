# LIMIT
-- 결과중에 딱 내가 원하는 만큼만 잘라서 줘! 라고 요청하는 키워드 // 구문의 가장 마지막에 위치

-- LIMIT [개수]
-- 상위 5개 잘라서 가져오기
select
	menu_code,
    menu_name,
    menu_price
from
	tbl_menu
order by
	menu_price desc
limit 5;

-- LIMIT [시작 위치(건너뛸 개수)], [개수] (게시판 페이징의 핵심 원리)
-- 2번째 행부터 4개 행 가져오기
select
	menu_code,
    menu_name,
    menu_price
from
	tbl_menu
order by
	menu_price desc
limit 1, 4;