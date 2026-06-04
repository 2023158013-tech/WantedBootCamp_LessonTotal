package com.wanted.object.b_array;

public class Application01 {
    public static void main(String[] args) {

        /*comment
        *  배열이란?
        *  동일한 자료형의 묶음이다.
        *  여기서 핵심 키포인트는 동일한 자료형!!
        *  배열은 heap영역에 생성이 되며, new 연산자를 통해 할당한다.
        *  new 키워드는 앞으로 할당 연산자라고 부르겠다. */

        /*
        * comment
        *  배열의 사용 이유
        *  1. 만약 배열을 사용하지 않는다면, 변수를 여러 개 만들어야 한다.
        *  2. 각각의 변수는 규칙이 없기 때문에 반복문을 통한 연속 처리가 불가능하다.
        *  ---
        *  배열의 사용 방법
        *  1. 자료형[] 변수명;, 자료형 변수명[](그냥 있구나)//선언
        *  2. new int[크기];, {값들}; //할당
        * */
        
        int[] iarr = new int[5]; //크기 지정 안하면 에러 발생
        System.out.println("iarr = " + iarr); //알 수 없는 주소값이 나옴
        System.out.println("iarr의 길이 = " + iarr.length);//String과 달리 메소드가 없음(그냥 변수임)

        //배열에 들어있는 값에 접근하는 방법
        System.out.println(iarr[0]); //heap은 값이 무조건 있어야 하는 영역이라서 자동으로 0으로 초기화됨(기본값)

        /*
        * comment
        *  중요!! heap 공간은 값이 비어있을 수 없다.
        *  그러나 우리는 값을 넣은 적이 없는데 0이라는 값이 출력되었다.
        *  그렇다는 것은 각 자료형 별 기본값으로 세팅이 된다는 것이다.
        *  ----
        *  정수: 0
        *  실수: 0.0
        *  논리: false
        *  문자: (유니코드 표시)(역슬래시가 탈출 기호라서 에러남)(|u000(원래는 역슬래시임))
        *  참조: null
        * */

        //10개의 정수가 들어갈 수 있는 배열 생성
        int[] iarr2 = new int[10];

        //초기값을 0으로 세팅하는 이유는? 배열은 0부터 시작하는 인덱스 번호 체계를 갖기 때문.
        for (int i = 0; i < iarr2.length; i++) {
            System.out.println("iarr2[" + i + "] 공간의 값: " + iarr2[i]);
        }

        String[] sarr = new String[5]; //참조 자료형(대문자로 시작)은 기본값이 null
        for (int i = 0; i < sarr.length; i++) {
            System.out.println("sarr[" + i + "] 공간의 값: " + sarr[i]);
        }

        //배열의 값에 접급하는 방식: 변수명[공간 변호(인덱스)]
        System.out.println("NullPointerException 발생: " + sarr[4].length());
        //sarr[4]=null -> null.length();를 한 것.
        //. -> 참조 연산자: 들어간다.
        //참조 연산자(.), 대입 연산자(공간(변수) = 리터럴(값)), 할당 연산자
    }
}
