use wanted_lms;
-- View란?
-- 가상의 테이블

-- [시나리오]
-- LMS 데이터 분석팀은 '과정별 등록 학생 수' 통계를 매일 확인한다.
-- 이 통계를 얻기 위해서는 enrollments 테이블을 조회하는 쿼리를 작성한다.
-- LMS 마케팅팀에게는 데이터분석팀이 사용자의 전체 정보를 오픈하지 않고 실제로 사용될 정보인 이메일/이름만 전달하고자 한다.

-- View를 사용하는 이유
-- 편의성: 복잡합 쿼리를 뷰로 만들게 되면 이후에는 마치 하나의 간단한 테이블처럼 쉽게 데이터를 조회할 수 있다.

-- 보안성: 원본 테이블의 민감한 정보를 숨기고 허용된 컬럼으로만 구성된 view(가상테이블)를 제공함으로써 테이블 접근을 숨길 수 있다.

-- View 만드는 표현식
-- create view [view 이름] as [쿼리문]
create view v_course_enrollments_status as
select
	c.course_id,
    c.title,
    count(e.enrollment_id) as '등록 학생 수'
from courses as c
left join enrollments as e on c.course_id = e.course_id
group by c.course_id, c.title;

-- v_course_enrollments_status를 테이블처럼 사용하기
select*from v_course_enrollments_status;

-- View를 사용해서 등록 학생 수가 3명 이상인 과정 찾아라.
select*from v_course_enrollments_status
where `등록 학생 수` >= 3;

-- 보안성을 위한 View 활용해보기.
-- 마케팅팀에게는 이메일을 보내기 위해, 아이디, 이름, 이메일, 활성 상태만  알아도 된다.
-- 비밀번호나 로그인 일시같은 민감한데이터는 노출할 필요가 없다.
select*from users;

-- 변수 명명법
-- _: 스네이크 케이스(합성어 사이)
-- maxNumber(카멜 케이스), max_number
create view v_user_public_info as
select
	user_id,
    name,
    email,
    status
from users
where status = 'active';

select*from v_user_public_info;

-- 만들어진 View를 관리하는 방법

-- 목록 확인
show full tables in wanted_lms where table_type like 'VIEW'; 

-- 뷰 수정
-- create or replace view 구문을 사용한다.
create or replace view v_user_public_info as
select
	user_id,
    name,
    email,
    status
    created_at
from users
where status = 'active';

-- 뷰 삭제
-- drop view [view 명]
drop view v_course_enrollments_status;
drop view v_user_public_info;