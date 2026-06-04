use chundb;

-- level 1
-- 1. 춘 기술대학교의 학과 이름과 계열을 표시하시오. 단, 출력 헤더는 "학과명", "계열"으로 표시하도록 한다.
select
	DEPARTMENT_NAME as "학과명", CATEGORY as "계열"
from tb_department;

-- 2. 학과의 학과 정원을 다음과 같은 형태로 화면에 출력
select
	concat(DEPARTMENT_NAME, '의 정원은 ', CAPACITY, '입니다.')
from tb_department;

-- 3. "국어국문학과"에 다니는 여학생 중 현재 휴학중인 여학생을 찾아달라는 요청이 들어왔다. 누구인가?(국문학과의 '학과코드'는 학과테이블을 조회)
select
	STUDENT_NAME
from tb_student
where ABSENCE_YN = 'Y' 
and DEPARTMENT_NO = '001' 
and (STUDENT_SSN like '%-2%' or STUDENT_SSN like '%-4%');

-- 4. 도서관에서 대출 도서 장기 연체자들을 찾아 이름을 게시하고자 한다. 그 대상자들의 학번이 다음과 같을 때 대상자들을 찾는 SQL 구문을 작성하시오.
-- A513079, A513090, A513091, A513110, A513119
select
	STUDENT_NAME
from tb_student
where STUDENT_NO in ('A513079', 'A513090', 'A513091', 'A513110', 'A513119')
order by STUDENT_NAME desc;

-- 5. 입학 정원이 20명 이상 30명 이하인 학과들의 학과 이름과 계열을 출력하시오.
select
	DEPARTMENT_NAME, CATEGORY
from tb_department
where CAPACITY between 20 and 30;

-- 6. 춘기술대학교는 총장을 제외하고 모든 교수들이 소속학과를 가지고 있다. 그럼 춘기술대학교 총장의 이름을 알아낼 수 있는 SQL문장을 작성하시오.
select
	PROFESSOR_NAME
from tb_professor
where DEPARTMENT_NO is null;

-- 7. 혹시 전산상의 착오로 학과가 지정되어 있지 않은 학생이 있는지 확인하고자 한다.
select
	STUDENT_NAME, DEPARTMENT_NO
from tb_student
where DEPARTMENT_NO is null;

-- 8. 수강신청을 하려고 한다. 선수 과목 여부를 확인해야 하는데, 선수 과목이 존재하는 과목들은 어떤 과목인지 과목 번호를 조회
select
	CLASS_NO
from tb_class
where PREATTENDING_CLASS_NO is not null;

-- 9. 춘 대학에는 어떤 계열들이 있는지 조회
select
	distinct CATEGORY
from tb_department
order by CATEGORY asc;

-- 10. 19학번 전주 거주자들의 모임을 만들려고 한다. 휴학한 사람들은 제외하고, 재학중인 학생들의 학번, 이름, 주민번호를 출력하는 구문을 작성하시오.
select
	STUDENT_NO, STUDENT_NAME, STUDENT_SSN
from tb_student
where DATE_FORMAT(ENTRANCE_DATE, '%y') = '19' and STUDENT_ADDRESS like '%전주%' and ABSENCE_YN = 'N'
order by STUDENT_NAME asc;

-- level 2
-- 1. 영어영문학과('002') 학생들의 학번과 이름, 입학 년도를 입학년도가 빠른 순으로 표시하는 SQL문장을 작성하시오.
-- (단, 헤더는 "학번", "이름", "입학년도"가 표시되도록 한다.)
select
	STUDENT_NO as "학번",
    STUDENT_NAME as "이름",
    ENTRANCE_DATE as "입학년도"
from tb_student
where DEPARTMENT_NO = '002'
order by ENTRANCE_DATE asc;

-- 2. 춘기술대학교의 교수 중 이름이 세 글자가 아닌 교수가 두 명 있다고 한다. 그 교수의 이름과 주민번호를 화면에 출력
select
	PROFESSOR_NAME, PROFESSOR_SSN
from tb_professor
where PROFESSOR_NAME not like '___';

-- 3. 춘기술대학교의 남자 교수들의 이름과 나이를 출력하는 SQL문장을 작성하시오.
-- (단, 이때 나이가 적은 사람에서 많은 사람 순서로 화면에 출력되도록 만드시오.)
-- (단, 교수 중 2000년 이후 출생자는 없으며 출력 헤더는 "교수 이름", "나이"로 한다. 나이는 '만'으로 계산한다.)
SELECT
    PROFESSOR_NAME AS "교수 이름",
    ( (DATE_FORMAT(SYSDATE(), '%Y') - (1900 + SUBSTR(PROFESSOR_SSN, 1, 2))) 
      - (CASE WHEN DATE_FORMAT(SYSDATE(), '%m%d') < SUBSTR(PROFESSOR_SSN, 3, 4) THEN 1 ELSE 0 END)
      -- 현재 날짜가 생일보다 작으면 생일이 아직 안 지남 -> 1, 아니면 0 빼기
    ) AS "나이"
FROM tb_professor
WHERE SUBSTR(PROFESSOR_SSN, 8, 1) = '1'
ORDER BY 나이 ASC;

-- 4. 교수들의 이름 중 성을 제외한 이름만 출력(출력 헤더는 '이름'이 찍히도록 한다.(성이 2자인 경우의 교수는 없다고 가정)
select
	substr(PROFESSOR_NAME, 2) as '이름'
from tb_professor;

-- 5. 춘기술대학교의 재수생 입학자를 구하려고 한다. 어떻게 찾아낼 것인가?
-- (이때, 만 19살이 되는 해에 입학하면 재수를 하지 않은 것으로 간주한다.)
select
	STUDENT_NO, STUDENT_NAME
from tb_student
where (date_format(ENTRANCE_DATE, '%Y') - year((str_to_date(substr(STUDENT_SSN, 1, 6), '%y%m%d')))) >19;

-- 6. 2020년 크리스마스는 무슨 요일이었는가?
select
	dayname('2020-12-25') as "2020년 크리스마스";
    
-- 7. STR_TO_DATE('99/10/11', '%y/%m/%d') STR_TO_DATE('49/10/11', '%y/%m/%d')은 각각 몇 년 몇 월 몇 일을 의미할까? 
select
	str_to_date('99/10/11', '%y/%m/%d'), -- 1999-10-11
    str_to_date('49/10/11', '%y/%m/%d'); -- 2049-10-11
-- 또 STR_TO_DATE('70/10/11', '%y/%m/%d') STR_TO_DATE('69/10/11', '%y/%m/%d') 은 각각 몇 년 몇 월 몇 일을 의미할까?
select
	str_to_date('70/10/11', '%y/%m/%d'), -- 1970-10-11
    str_to_date('69/10/11', '%y/%m/%d'); -- 2069-10-11

-- 8. 학번이 A517178인 한아름 학생의 학점 총 평점을 구하는 SQL문을 작성.
-- (단, 이때 출력 화면의 헤더는 "평점"이라고 찍히게 하고, 점수는 반올림하여 소수점 이하 한 자리까지만 표시)
select
	(round(avg(POINT), 1)) as "평점"
from tb_grade
where STUDENT_NO = 'A517178';

-- 9. 학과별 학생 수를 구하여 "학과번호", "학생수(명)"의 형태로 헤더를 만들어 결과값이 출력되도록 하시오.
select
	distinct DEPARTMENT_NO as "학과번호",
	count(STUDENT_NO) as "학생수(명)"
from tb_student
-- where ABSENCE_YN = 'N'(휴학생은 제외하려고 했었음.. 근데 답이랑 다름)
group by DEPARTMENT_NO;

-- 10. 지도 교수를 배정받지 못한 학생의 수는 몇 명 정도인지 알아내는 SQL문을 작성
select
	count(*)
from tb_student
where COACH_PROFESSOR_NO is null;

-- 11. 학번 A112113인 김고운 학생의 년도별 평점을 구하는 SQL문을 작성.
-- (단, 이때 출력 화면의 헤더는 "년도", "년도별 평점"이라고 찍히게 하고, 점수는 반올림하여 소수점 이하 한 자리까지만 표시)
select
	substr(TERM_NO, 1, 4) as "년도",
    round(avg(POINT), 1) as "년도별 평점"
from tb_grade
where STUDENT_NO = 'A112113'
group by 년도;

-- 12. 학과별 휴학생 수를 파악하고자 한다. 학과 번호와 휴학생 수를 표시하는 SQL문장을 작성
select
	DEPARTMENT_NO as "학과코드명",
    sum(ABSENCE_YN = 'Y') as "휴학생 수"
from tb_student
group by DEPARTMENT_NO;
-- count 안에 STUDENT_NO를 넣으면 WHERE절에 휴학생 조건을 넣어야 하는데 그러면 0명인 경우가 안나옴.
-- 그래서 count 안에 휴학생 조건식을 넣으면 모든 학생 수를 세줌. count는 조건식이 null이 아니면 1을 추가하기 때문.
-- sum는 안에 조건식이 참일 때만 1을 추가하기 때문에 가능.

-- 13. 춘대학교에 다니는 동명이인 학생들의 이름을 찾고자 한다.
select
	STUDENT_NAME as "동일이름",
    count(*) as "동명인 수"
from tb_student
group by STUDENT_NAME
having `동명인 수` > 1
order by STUDENT_NAME asc;

-- 14. 학번이 A112113인 김고운 학생의 년도, 학기별 평점과 년도별 누적 평점, 총평점을 구하시오.
-- (단, 평점은 소수점 1자리까지만 반올림하여 표시)
select
	substr(TERM_NO, 1, 4) as "년도",
    substr(TERM_NO, 5, 2) as "학기",
    round(avg(POINT), 1) as "평점"
from tb_grade
where STUDENT_NO = 'A112113'
group by `년도`, `학기` with rollup;