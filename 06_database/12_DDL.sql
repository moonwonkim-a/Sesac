/* DDL(Data Definition Language) */
-- 데이터 정의 언어 (CREATE, ALTER, DROP)

#CREATE
-- 테이블 생성을 위한 구문alter
/*
create table 테이블명 (
	컬럼명 데이터타입(길이) 제약조건,
    컬럼명 데이터타입(길이) 제약조건,
    ...
*/
-- if not exists ... : ...테이블이 존재하지 않을 때만 생성하기 위한 구문
create table if not exists tb1(
	pk int primary key,
    fk int,
    col1 varchar(225),
    check(col1 in('Y','N'))
) engine = innodb;

describe tb1;	-- 테이블 정보 확인

insert into tb1 values(1, 10, 'Y');

select * from tb1;

-- AUTO_INCREMENT
-- INSERT시 PRIMARY KEY에 해당하는 컬럼에 자동으로 번호를 발생(중복되지 않게)시켜 저장할 수 있다.
-- tb2 생성
create table if not exists tb2(
	pk int auto_increment primary key,
    fk int,
    col1 varchar(225),
    check(col1 in('Y','N'))
) engine = innodb;

describe tb2;

-- pk값에 null을 주면 자동으로 번호가 채워진다.
insert into tb2 values (null, 10, 'Y');
insert into tb2 values (null, 20, 'Y');

select * from tb2;

# ALTER
-- 테이블에 추가/변경/수정/삭제하는 모든 것은 ALTER 명령어를 사용해 적용한다.

-- tb2 테이블에 'co12' 정수형 컬럼 추가
alter table tb2
add co12 int not null;		-- 열(컬럼)을 추가할 때 add 사용

describe tb2;

-- 'co12' 컬럼 삭제
alter table tb2
drop column co12;	-- 열(컬럼)을 삭제할 때는 drop column 사용

describe tb2;

-- 'fk' 컬럼 이름과 데이터 형식, 제약조건 바꾸기
alter table tb2
change column fk change_fk int not null;

describe tb2;


alter table tb2
drop primary key;	-- 에러 발생 (auto increment 걸려 있기 때문)

-- auto_increment가 적용되어 있는 컬럼의 경우 먼저 auto_increment를 삭제한 다음 삭제
-- MODIFY : 컬럼의 정의(속성) 변경
alter table tb2
modify pk int;

describe tb2;

-- 이제 primary key 삭제 가능
alter table tb2
drop primary key;

-- 다시 제약조건 추가
alter table tb2 add primary key(pk);	-- pk에 primary key를 추가

describe tb2;

# DROP
-- 테이블의 구조와 데이터를 영구적으로 삭제(되돌릴 수 없음)

create table if not exists tb3(
	pk int auto_increment primary key,
    fk int,
    col1 varchar(225),
    check(col1 in('Y','N'))
) engine = innodb;

-- tb3 삭제. if exists를 붙이면 테이블이 없어도 에러가 나지 않음
drop table if exists tb3;	-- ,를 이용하여 여러 테이블도 삭제 가능 ex) drop table table1, table2, talbe3 ...;

#TRUNCATE
-- 테이블 내용물만 비우고 초기화하기 (테이블의 구조는 남겨두고, 데이터만 깨끗하게 비우고 싶을 때 사용하면 효율적)

create table if not exists tb4(
	pk int auto_increment primary key,
    fk int,
    col1 varchar(225),
    check(col1 in('Y','N'))
) engine = innodb;

insert into tb4 values (null, 10, 'Y'), (null, 20, 'N');

select * from tb4;

-- 테이블 초기화
truncate table tb4;

-- 다시 데이터를 넣으면 pk가 1부터 시작한다.
insert into tb4 values (null, 10, 'Y'), (null, 20, 'N');
