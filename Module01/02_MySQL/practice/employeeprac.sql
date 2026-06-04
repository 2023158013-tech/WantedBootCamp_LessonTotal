use employee;
-- select 기초
-- 모든 행, 모든 컬럼 조회(EMPLOYEE테이블에서 모든 정보 조회)
select*from employee;

-- 원하는 컬럼 조회(EMPLOYEE 테이블의 사번, 이름 조회)
select
	EMP_ID, EMP_NAME
from employee;

-- 원하는 행 조회(EMPLOYEE 테이블에서 부서코드가 D9인 사원 조회)
select
	*
from employee
where DEPT_CODE = 'D9';

-- 원하는 행과 컬럼 조회 
-- (EMPLOYEE 테이블에서 급여가 300만원 이상인 사원의 사번, 이름, 부서코드, 급여를 조회)
select
	EMP_ID, EMP_NAME, DEPT_CODE, SALARY
from employee
where SALARY >= 3000000;

-- (부서코드가 D6이고 급여를 200만원보다 많이 받는 직원의 이름, 부서코드, 급여 조회)
select
	EMP_NAME, DEPT_CODE, SALARY
from employee
where DEPT_CODE = 'D6' and SALARY >= 2000000;

-- NULL값 조회(보너스를 지급받지 않는 사원의 사번, 이름, 급여, 보너스를 조회)
select
	EMP_ID, EMP_NAME, SALARY, BONUS
from employee
where BONUS is null;

-- (EMPLOYEE 테이블에서 급여를 350만원 이상 550만원 이하를 받는 직원의 사번, 이름, 급여, 부서코드, 직급 코드를 조회)
select
	EMP_ID, EMP_NAME, SALARY, DEPT_CODE, JOB_CODE
from employee
where SALARY between 3500000 and 5500000;

-- (EMPLOYEE 테이블에서 성이 김씨인 직원의 사번, 이름, 입사일 조회)
select
	EMP_ID, EMP_NAME, HIRE_DATE
from employee
where EMP_NAME like '김%';

-- (EMPLOYEE 테이블에서 '하'가 이름에 포함된 직원의 이름, 주민번호, 부서코드 조회)
select
	EMP_NAME, EMP_NO, DEPT_CODE
from employee
where EMP_NAME like '%하%';

-- (EMPLOYEE 테이블에서 전화번호 국번(가운데)이 9로 시작하는 직원의 사번, 이름, 전화번호를 조회)(와일드카드 사용: _글자 한자리, %0개 이상의 글자)
select
	EMP_ID, EMP_NAME, PHONE
from employee
where PHONE like '___9%';

-- (EMPLOYEE 테이블에서 전화번호 국번이 4자리이면서 9로 시작하는 직원의 사번, 이름, 전화번호를 조회)!
select
	EMP_ID, EMP_NAME, PHONE
from employee
where PHONE like '___9___%';

-- (부서코드가 'D6'이거나 'D8'인 직원의 이름, 부서, 급여를 조회)(IN 연산자: 비교하려는 값 목록에 일치하는 값이 있는지 확인)
select
	EMP_NAME, DEPT_CODE, SALARY
from employee
where DEPT_CODE IN ('D6', 'D8');

-- (이씨성이 아닌 직원의 사번, 이름, 이메일 주소 조회)
select
	EMP_ID, EMP_NAME, EMAIL
from employee
where EMP_NAME not like '이%';

-- (J2 직급의 급여 200만원 이상 받는 직원이거나 J7 직급인 직원의 이름, 급여, 직급코드 조회)
select
	EMP_NAME, SALARY, JOB_CODE
from employee
where SALARY >= 2000000 or JOB_CODE = 'J7';

-- (J7 직급이거나 J2 직급인 직원들 중 급여가 200만원 이상인 직원의 이름, 급여, 직급 코드를 조회)
select
	EMP_NAME, SALARY, JOB_CODE
from employee
where JOB_CODE in ('J7', 'J2') and SALARY >= 2000000;

-- 집계함수, Grouping
-- (EMPLOYEE 테이블에서 직원들의 주민번호를 조회하여 사원명, 생년, 생월, 생일을 각각 분리하여 조회)(단, 컬럼의 별칭은 사원명, 생년, 생월, 생일로 한다.)
select
	EMP_NO,
    EMP_NAME as '사원명',
    SUBSTR(EMP_NO, 1, 2) as '생년',
    SUBSTR(EMP_NO, 3, 2) as '생월',
    SUBSTR(EMP_NO, 5, 2) as '생일'
from employee;

-- 날짜 데이터에서 사용할 수 있다.(직원들의 입사일에도 입사년도, 입사월, 입사날짜를 분리하여 조회)
select
	HIRE_DATE,
    DATE_FORMAT(HIRE_DATE, '%Y') as '입사년도',
    DATE_FORMAT(HIRE_DATE, '%m') as '입사월',
    DATE_FORMAT(HIRE_DATE, '%d') as '입사날짜'
from employee;

-- WHERE절에서 함수 사용도 가능하다.(여직원들의 모든 컬럼 정보를 조회)
select
	*
from employee
where EMP_NO like '%-2%';

-- 함수 중첩 사용 가능: 함수 안에서 함수를 사용할 수 있음
-- (EMPLOYEE 테이블에서 사원명, 주민번호 조회)(단, 주민번호는 생년월일만 보이게 하고, '-' 다음의 값은 '*'로 바꿔서 출력)
select
	EMP_NAME, EMP_NO,
    concat(substr(EMP_NO, 1, 7), '*******') as '주민번호'
from employee;

-- (EMPLOYEE 테이블에서 사원명, 이메일, @ 이후를 제외한 아이디 조회)
select
	EMP_NAME, EMAIL,
    substr(EMAIL, 1, instr(EMAIL, '@')-1) as '아이디'
from employee;

-- (EMPLOYEE 테이블에서 근무 년수가 20년 이상인 직원 조회)!
select
	*
from employee
where (ifnull(ENT_DATE, sysdate()) - HIRE_DATE) >= 20; 

-- (EMPLOYEE 테이블에서 사원명, 입사일, 입사한 월의 근무일수를 조회)
select
	EMP_NAME, HIRE_DATE,
    DATEDIFF(LAST_DAY(HIRE_DATE), HIRE_DATE) + 1 as '입사월 근무일수'
from employee;

-- (EMPLOYEE 테이블에서 직원의 이름, 입사일, 근무년수를 조회)(단, 근무년수는 현재년도-입사년도로 조회)
select
	EMP_NAME, HIRE_DATE,
    (DATE_FORMAT(sysdate(), '%Y') - DATE_FORMAT(HIRE_DATE, '%Y')) as '입사년도'
from employee;

-- (EMPLOYEE 테이블에서 사번이 홀수인 직원들의 모든 정보 조회)(mod)
select
	*
from employee
where mod(EMP_ID, 2) = 1;