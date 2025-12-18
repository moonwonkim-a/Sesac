/* DML(Data Manipulation Language) */

-- INSERT, UPDATE, DELETE, SELECT(DQL)

# INSERT
-- 새로운 행을 추가하는 구문이다. (테이블의 행의 수가 증가한다)

-- 테이블의 컬럼 순서에 맞춰 모든 값을 순서대로 제공한다.
insert into tbl_menu values(null, '바나나해장국', 8500, 4,'Y'); -- null을 넣어주면 자동으로 그 다음 키값으로 지정됨

-- intsert 하고싶은 데이터 컬럼을 지정해서 insert 가능하다.
-- 테이블 이름 뒤에 값을 넣을 칼럼들을 명시한다.
-- 무조건 테이블 순서대로 맞출 필요 없다. 값을 넣을 때 명시된 순서에 맞게만 지정해 주면 된다.
INSERT INTO tbl_menu(menu_name, menu_price, category_code, orderable_status)
values ('초콜릿죽', 6500, 7, 'Y');

-- 한번에 여러 행 추가하기
insert into
	tbl_menu
values
	(null, '참치맛아이스크림', 17000, 12, 'Y'),
    (null, '멸치맛아이스크림', 1500, 11, 'Y'),
    (null, '소시지맛커피', 2500, 8, 'Y');
    
select * from tbl_menu;

# UPDATE
-- 테이블에 이미 존재하는 행의 컬럼의 값을 수정하는 구문이다.

-- 1단계 : 내가 바꾸려는 대상이 맞는지 SELECT로 확인
select
	menu_code,
    category_code
from
	tbl_menu
where
	menu_name = '바나나해장국';
    
-- 2단계 : 확인된 대상을 WHERE 절에 넣고 UPDATE 실행
-- WHERE을 안넣고 실행하면 해당 컬럼의 내용이 전부다 바뀌게 됨
UPDATE tbl_menu
SET
	category_code = 7	-- 바꿀 내용
WHERE
	menu_code = 22;		-- 바꿀 대상

# DELETE
-- 테이블에서 특정 행을 삭제하는 구문이다

-- 1단계 : 삭제할 대상 확인('바나나해장국')
SELECT * FROM tbl_menu where menu_code = 22;

-- 2단계 : 확인된 대상을 WHERE 절에 넣고 DELETE 실행
-- update와 마찬가지로 where절을 넣지 않으면 해당 컬럼 전체가 삭제되는 상황이 발생한다.
DELETE
FROM
	tbl_menu
where
	menu_code = '22';

# REPLACE
-- INSERT시 PRIMARY KEY 또는 UNIQUE KEY가 충돌이 발생할 수 있다면
-- REPLACE를 통해 중복 된 데이터를 덮어 쓸 수 있다.


-- PRIMARY KEY 중복 에러 발생
INSERT INTO tbl_menu values(17, '참기름소주', 5000, 10, 'Y');

-- 해당 키의 데이터가 있으면 -> 기존 데이터를 삭제(DELETE)하고, 새로운 데이터로 INSERT 한다.
-- 꽤나 무거운 작업이기 때문에 꼭 필요한 상황일 때만 사용하자.
replace into tbl_menu values(17, '참기름소주', 5000, 10, 'Y');
