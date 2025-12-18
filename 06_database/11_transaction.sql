# Transaction (트랜잭션) - ALL or Nothing 모두 성공하거나, 모두 실패해야 하는 하나의 실행 묶음

-- MYSQL 은 기본적으로 autocommit 모드가 켜져있다. 조절하고 싶다면 설정을 바꿔줘야 한다.

set autocommit = off;	-- 영구적으로 off 시키는 방법 // 다시 키고싶으면 on

-- 지금부터 트랜잭션을 시작한다.(수동 커밋 모드로 전환)
start transaction;

select * from tbl_menu;

-- 임시 작업 // 트랜잭션이 종료 되기 전까지
insert into tbl_menu values (null, '바나나해장국', 8500, 4, 'Y');
update tbl_menu set menu_name = '수정된 메뉴' where menu_code = 5;
delete from tbl_menu where menu_code = 7;

-- start transaction 시점 이후에 수행했던 모든 작업을 '전부 취소' 하고 트랜잭션 시작 전의 상태로 되돌림
rollback;	-- commit 이후에는 rollback을 실행해도 소용없다.

-- 작업이 올바르다고 판단되면 최종 저장을 명령한다.
commit;