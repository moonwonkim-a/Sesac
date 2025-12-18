/* CONSTRAINTS(제약 조건) */

# NOT NULL
-- NULL값 허용하지 않음

CREATE TABLE IF NOT EXISTS user_notnull(
	user_no int not null,
    user_id varchar(255) not null,
    user_pwd varchar(255) not null,
    gender varchar(3)
)ENGINE=InnoDB;

insert into user_notnull values (1,'user01','pass01','남');

select * from user_notnull;

insert into user_notnull values (2,'user02',null,'여');	-- null값을 허용하지 않기 때문에 에러

#UNIQUE
-- 중복값 허용하지 않음

CREATE TABLE IF NOT EXISTS user_unique(
	user_no int not null unique,	-- 회원번호는 중복될 수 없다. (컬럼 레벨 선언 방식)
    user_id varchar(255) not null,
    user_pwd varchar(255) not null,
    gender varchar(3),
    unique (user_id)	-- id도 중복될 수 없다.(테이블 레벨 선언 방식)
)ENGINE=InnoDB;

insert into user_unique values (1,'user01','pass01','남');
insert into user_unique values (1,'user02','pass02','여');	-- 회원번호가 중복되었기 때문에 에러가 발생됨
insert into user_unique values (2,'user01','pass02','남');	-- id가 중복되었기 때문에 에러가 발생됨
insert into user_unique values (2,'user03','pass01','남');	-- unique 제약조건이 없다면 중복이 되어도 정상 실행

select * from user_unique;

#PRIMARY KEY
-- 테이블에서 한 행의 정보를 찾기 위해 사용 할 컬럼을 의미한다.
-- 테이블에 대한 대표 식별자 역할을 한다. (한 행씩 구분하는 역할)
-- NOT NULL + UNIQUE 제약조건의 의미를 가지고 있다.
CREATE TABLE IF NOT EXISTS user_primarykey(
	-- user_no int primary key,	-- 이 컬럼이 이 테이블의 대표 식별자
    user_no int,
    user_id varchar(255) not null,
    user_pwd varchar(255) not null,
    gender varchar(3),
    primary key(user_on)	-- 테이블 레벨 선언 가능	
)ENGINE=InnoDB;

-- 1. NULL 값 시도 (NOT NULL 위반)
insert into user_priamarykey values(null, 'user01', 'pass01', '남');

-- 2. 중복값 시도 (UNQUE 위반)
insert into user_primarykey values(1, 'user01','pass01','남');
insert into user_primarykey values(1, 'user02','pass03','남');

# FOREIGN KEY
-- 참조된 다른 테이블에서 제공하는 값만 사용할 수 있다.
-- 두 테이블을 연결하고 관계를 맺어준다.
-- 제공되는 값 외에는 NULL을 사용할 수 있다.

create table if not exists user_grade (
	grade_code int primary key,
    grade_name varchar(255) not null
) engine = innodb;

insert into user_grade values (10,'일반회원'),(20,'우수회원'),(30,'특별회원');

select * from user_grade;

create table if not exists user_foreignkey1 (
	user_no int primary key,
    grade_code int,
    -- 이 테이블의 grade_code는 user_grade 테이블의 grade_code를 참조한다.
    FOREIGN KEY (grade_code) references user_grade(grade_code)	
)engine = innodb;

insert into user_foreignkey1 values(1,10);
insert into user_foreignkey1 values(2,50);	-- 참조 컬럼에 없는 값을 적용하면 에러가 발생

#ON UPDATE / ON DELETE 옵션
-- SET NULL : 부모(user_grade)가 바뀌거나 사라지면, 해당 값을 NULL로 바꾼다.
-- CASCADE : 부모가 바뀌면 자식도 따라 바뀌고, 부모가 사라지면 자식도 함께 사라진다.

create table if not exists user_foreignkey2 (
	user_no int primary key,
    grade_code int,
    -- 이 테이블의 grade_code는 user_grade 테이블의 grade_code를 참조한다.
    FOREIGN KEY (grade_code) references user_grade(grade_code)
    ON UPDATE SET NULL
    ON DELETE SET NULL
)engine = innodb;

insert into user_foreignkey2 values (1, 10), (2, 20), (3, 30);
select * from user_foreignkey2;

DROP TABLE if exists user_foreignkey1;

-- 부모 테이블의 grade_code 수정
UPDATE user_grade
SET grade_code = 40
WHERE grade_code = 10;

# CHECK
-- 들어올 수 있는 값의 범위나 조건을 직접 지정
create table if not exists user_check(
	user_no int auto_increment primary key,
    user_name varchar(225) not null,
    gender varchar(3) CHECK (gender IN ('남','여')),
    age int CHECK (age >= 19)
)engine = innodb;

insert into user_check values (1,'홍길동','남',25);

select * from user_check;

-- check 제약조건 위반
insert into user_check values (null,'유관순','여성',25);	-- '여성' 이 check 제약조건에 위반되서 에러
insert into user_check values (null,'별','여',18);		-- age 컬럼의 check 제약조건에 위반되서 에러

# DEFAULT
-- INSERT시 특정 컬럼에 값을 주지 않으면, 자동으로 채워질 기본값을 지정한다.

create table if not exists user_country (
	country_code int auto_increment primary key,
    country_name varchar(255) DEFAULT '한국',
    add_day DATE DEFAULT (CURRENT_DATE),
    add_time DATETIME DEFAULT (CURRENT_TIME)
) engine = innodb;

insert into user_country values(null, default, default,default);

-- INSERT시 생략한 컬럼도 자동으로 default 값으로 설정 된다.
insert into user_country (country_code, country_name) values (null,'미국');

select * from user_country;