-- 1. enrollments, users, courses 세 테이블을 조인하고 어떤 학생이 어떤 강의를 듣는지 조회
select
	concat(name, '(학생)') as '이름',
    title as '강의 제목',
    date_format(enrolled_at, '%Y년 %m월 %d일') as '강의 등록일'
from users as u
inner join courses as c on u.user_id = c.author_id
inner join enrollments as e on c.course_id = e.course_id;

-- 2. users 테이블을 기준으로 user_profiles를 left join
select
	name as '이름',
    email as '이메일',
    ifnull(bio, '자기소개 없음') as '자기소개'
from users as u
left join user_profiles as up on u.user_id = up.user_id;
-- 프로필 데이터가 아예 없는 게 뭔솔

-- 3. 전체 유저의 평균 user_id값보다 큰 user_id를 가진 유저들의 정보
select
	user_id as '아이디',
    name as '이름',
    email as '이메일'
from users
where user_id > (
	select
		avg(user_id)
	from users
);

-- 춘대학 워크북
-- select - option
-- 1. 학생이름과 주소지 표시(단, 출력헤더는 "학생 이름", "주소지", 정렬은 이름으로 오름차순)
select
	STUDENT_NAME as "학생 이름",
    STUDENT_ADDRESS as "주소지"
from tb_student
order by STUDENT_NAME asc;

-- 2. 휴학 중인 학생들의 이름과 주민번호를 나이가 적은 순서로 화면에 출력
select
	STUDENT_NAME,
    STUDENT_SSN
from tb_student
where ABSENCE_YN = 'Y'
order by 
	case 
		when substr(STUDENT_SSN, 8, 1) in (3, 4) then concat('20', substr(STUDENT_SSN, 1, 6))
        else concat('19', substr(STUDENT_SSN, 1, 6))
	end
asc;


-- 3. 3번 건너뜀
-- 4.현재 법학과 교수 중 가장 나이가 많은 사람부터 이름을 확인할 수 있는 SQL문장을 작성(법학과 학과코드는 조회해서 찾기)
select
	DEPARTMENT_NO as '법학과 코드'
from tb_department
where DEPARTMENT_NAME = '법학과';
-- 005
select
	PROFESSOR_NAME,
    PROFESSOR_SSN
from tb_professor
where DEPARTMENT_NO = '005'
order by (now() - concat('19', substr(PROFESSOR_SSN, 1, 6))) desc;
    
-- 5. 2022년 2학기에 'C3118100' 과목을 수강한 학생들의 학점을 조회. 학점이 높은 학생부터 표시, 학점이 같으면 학번이 낮은 학생부터 표시
select
	STUDENT_NO,
    POINT
from tb_grade
where CLASS_NO = 'C3118100' and TERM_NO = '202202'
order by
	POINT desc,
    STUDENT_NO asc; -- 학점이 높은 순으로 먼저 정렬하고 학번이 낮은 순으로 정렬하면 동점자에 대해 알아서 정렬됨.
    
-- 6. 학생 번호, 학생 이름, 학과 이름을 학생 이름의 오름차순으로 정렬하여 출력
select
	STUDENT_NO,
    STUDENT_NAME,
    DEPARTMENT_NAME
from tb_student as s
join tb_department as d on s.DEPARTMENT_NO = d.DEPARTMENT_NO
order by STUDENT_NAME asc;

-- 7. 춘기술대학교의 과목 이름과 과목의 학과 이름을 출력
select
	CLASS_NAME,
    DEPARTMENT_NAME
from tb_class as c
join tb_department as d on d.DEPARTMENT_NO = c.DEPARTMENT_NO;

-- 8. 과목별 교수 이름을 찾으려 함. 과목 이름과 교수 이름을 출력
select
	CLASS_NAME,
	PROFESSOR_NAME
from tb_class as c
join tb_professor as p on p.DEPARTMENT_NO = c.DEPARTMENT_NO
order by PROFESSOR_NAME asc;    

-- 9. 8번의 결과 중 '인문사회' 계열에 속한 과목의 교수 이름을 찾으려고 한다.
select
	CLASS_NAME,
	PROFESSOR_NAME
from tb_class as c
join tb_professor as p on p.DEPARTMENT_NO = c.DEPARTMENT_NO
join tb_department as d on d.DEPARTMENT_NO = c.DEPARTMENT_NO
where d.CATEGORY = '인문사회'
order by PROFESSOR_NAME asc;  

-- 10. '음악학과' 학생들의 평점 구하기. 학번, 학생 이름, 전체 평점을 출력(평점은 소수점 1자리까지만 반올림)
select
	s.STUDENT_NO as "학번",
    s.STUDENT_NAME as "학생 이름",
    round(avg(POINT), 1) as "전체 평점"
from tb_student as s
join tb_grade as g on s.STUDENT_NO = g.STUDENT_NO
join tb_department as d on s.DEPARTMENT_NO = d.DEPARTMENT_NO
where d.DEPARTMENT_NAME = '음악학과'
group by s.STUDENT_NO, s.STUDENT_NAME
order by `전체 평점` desc;

-- 11. 학번이 A313047인 학생이 학교에 나오지 않는 사실을 지도교수에세 전달하기 위해 학과 이름, 학생 이름, 지도교수 이름이 필요.
-- 출력헤더는 "학과이름", "학생이름", "지도교수이름"
select
	d.DEPARTMENT_NAME as "학과이름",
	s.STUDENT_NAME as "학생이름",
    p.PROFESSOR_NAME as "지도교수이름"
from tb_department as d
join tb_student as s on d.DEPARTMENT_NO = s.DEPARTMENT_NO -- 학생 테이블의 학과번호와 학과 테이블의 학과번호가 일치하는 것
join tb_professor as p on s.COACH_PROFESSOR_NO = p.PROFESSOR_NO -- 학생 테이블의 지도교수번호와 교수 테이블의 교수번호가 일치하는 것
where s.STUDENT_NO = 'A313047';

-- 12. 2023년도에 '인간관계론' 과목을 수강한 학생을 찾아 학생이름과 수강학기를 표시.
-- 인간관계론을 같은 학기에 수강한 학생이 여러명 있는 학기가 어떤 학기인지 찾기 위한 구문. 2023년도에 수강한 학생 많음.
select
	c.CLASS_NAME,
    g.TERM_NO,
    s.STUDENT_NAME
from tb_class as c
join tb_grade as g on c.CLASS_NO = g.CLASS_NO
join tb_student as s on g.STUDENT_NO = s.STUDENT_NO
where c.CLASS_NAME = '인간관계론'
group by s.STUDENT_NAME, g.TERM_NO, c.CLASS_NAME
having (count(substr(g.TERM_NO, 1, 4)) >= 1);
-- 2023년도에 '인간관계론' 과목을 수강한 학생을 찾아 학생이름과 수강학기를 표시.
select
	s.STUDENT_NAME,
    g.TERM_NO
from tb_student as s
join tb_grade as g on s.STUDENT_NO = g.STUDENT_NO
join tb_class as c on g.CLASS_NO = c.CLASS_NO
where c.CLASS_NAME = '인간관계론' and (g.TERM_NO like '2023%');

-- 13. 예체능 계열 과목 중 과목 담당 교수를 한 명도 배정받지 못한 과목을 찾아 그 과목 이름과 학과 이름을 출력
select
	c.CLASS_NAME,
	d.DEPARTMENT_NAME
from tb_class as c
join tb_department as d on c.DEPARTMENT_NO = d.DEPARTMENT_NO
left join tb_class_professor as cp on c.CLASS_NO = cp.CLASS_NO
where d.CATEGORY = '예체능' and (cp.PROFESSOR_NO is null);

-- 14. 춘기술대학교 서반아어학과 학생들의 지도교수를 게시하고자 한다. 학생이름과 지도교수 이름을 찾고 만일 지도교수가 없는 학생일 경우 "지도교수 미지정"으로 표시.
-- 출력 헤더는 "학생이름", "지도교수"로 표시하며 고학번 학생이 먼저 출력되도록 함.
select
	s.STUDENT_NAME as "학생이름",
    ifnull(p.PROFESSOR_NAME, '지도교수 미지정') as "지도교수"
from tb_student as s
left join tb_professor as p on s.COACH_PROFESSOR_NO = p.PROFESSOR_NO
join tb_department as d on s.DEPARTMENT_NO = d.DEPARTMENT_NO
where d.DEPARTMENT_NAME = '서반아어학과'
order by s.STUDENT_NO asc;

-- 15. 휴학생이 아닌 학생 중 평점이 4.0 이상인 학생을 찾아 그 학생의 학번, 이름, 학과이름, 평점을 출력.
select
	s.STUDENT_NO as '학번',
    s.STUDENT_NAME as '이름',
    d.DEPARTMENT_NAME as '학과 이름',
    avg(g.POINT) as '평점'
from tb_student as s
join tb_department as d on s.DEPARTMENT_NO = d.DEPARTMENT_NO
join tb_grade as g on s.STUDENT_NO = g.STUDENT_NO
where s.ABSENCE_YN = 'N'
group by s.STUDENT_NO, s.STUDENT_NAME, d.DEPARTMENT_NAME -- select에 나온 컬럼들을 다같이 묶기
having `평점` >= 4.0
order by s.STUDENT_NAME asc;

-- 16. 환경조경학과 전공과목들의 과목별 평점을 파악할 수 있는 SQL문을 작성.
select
	c.CLASS_NO,
    c.CLASS_NAME,
    avg(g.POINT)
from tb_grade as g
join tb_class as c on g.CLASS_NO = c.CLASS_NO
join tb_department as d on c.DEPARTMENT_NO = d.DEPARTMENT_NO
where d.DEPARTMENT_NAME = '환경조경학과'
group by c.CLASS_NO, c.CLASS_NAME;

-- 17. 춘기술대학교에 다니고 있는 최경희 학생과 같은 과 학생들의 이름과 주소를 출력.
select
	STUDENT_NAME,
    STUDENT_ADDRESS
from tb_student
where DEPARTMENT_NO = (
	select
		DEPARTMENT_NO
	from tb_student
	where STUDENT_NAME = '최경희'
    )
order by STUDENT_NAME asc;

-- 18. 국어국문학과에서 총 평점이 가장 높은 학생의 이름과 학번을 표시.
select
	s.STUDENT_NO,
    s.STUDENT_NAME
from tb_student as s
join tb_grade as g on s.STUDENT_NO = g.STUDENT_NO
join tb_department as d on s.DEPARTMENT_NO = d.DEPARTMENT_NO
where d.DEPARTMENT_NAME = '국어국문학과'
group by s.STUDENT_NO, s.STUDENT_NAME
order by avg(g.POINT) desc 
limit 1; -- 성적이 높은 순으로 정렬 후 1명만 출력되게.

-- 19. 춘기술대학교의 "환경조경학과"가 속한 같은 계열 학과들의 학과별 전공과목 평점을 파악하기 위한 적절한 SQL문을 찾아내시오.
-- 단, 출력헤더는 "계열 학과명", "전공평점"으로 표시되도록 하고, 평점은 소수점 한 자리까지만 반올림하여 표시)
select
	d.DEPARTMENT_NAME as "계열 학과명",
    round(avg(g.POINT)) as "전공평점"
from tb_department as d
join tb_class as c on c.DEPARTMENT_NO = d.DEPARTMENT_NO
join tb_grade as g on c.CLASS_NO = g.CLASS_NO
where d.CATEGORY = (
	select
    d.DEPARTMENT_NAME = '환경조경학과'
group by d.CATEGORY