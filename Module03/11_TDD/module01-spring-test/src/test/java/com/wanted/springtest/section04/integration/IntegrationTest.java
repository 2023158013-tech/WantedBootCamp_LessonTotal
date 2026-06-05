package com.wanted.springtest.section04.integration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/*comment
*  @SpringBootTest
*  -Spring의 전체 컨테스트를 로딩한다.
*  -즉, IoC 컨테이너를 로딩한다.
*  -통합 테스트 시에 사용하게 된다.
*  */

@SpringBootTest
public class IntegrationTest {

    private UserService userService;
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        //실제로는 나중에 @Autowired로 가져오면 된다.
        //지금은 학습 편의상 Bean으로 등록하지 않았기 때문에 mock 객체로 만든다.
        userRepository = mock(UserRepository.class); //가짜 객체 만들어두고 서비스 생성 시점에 주입

        //userService에 Mock 주입
        userService = new UserService(userRepository);
    }

    @Test
    void 이메일_중복_시_예외_발생_테스트() {

        //given: 중복 이메일 상황 설정
        User newUser = new User("김철수", "test@example.com");
        //해당 이메일이 존재한다는 상황 강제화
        when(userRepository.existsByEmail("test@example.com")).thenReturn(true);
        //"test@example.com" 대신 newUser.getEmail() 써도 되는지?

        //Service에서 Throw한 예외가 발생하는 지 Test
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> userService.createUser(newUser)
        );

        assertEquals("이미 존재하는 이메일입니다: test@example.com", exception.getMessage());

    }

    @Test
    void 유효한_ID로_사용자_조회_테스트() {

        //given: 사용자 데이터 설정
        Long userId = 1L; //Long타입은 뒤에 L을 붙여야함. 소문자 l은 숫자처럼 보여서 대문자 지향
        User expectUser = new User(userId, "라쿤", "raccoon@test.com", true);

        //expect
        when(userRepository.findById(userId)).thenReturn(Optional.of(expectUser)); //Optional<T> of->"~로". => Optional<User>

        //when: 조회
        Optional<User> actualUser = userService.findUserById(userId);

        //then: 검증
        assertEquals("라쿤", actualUser.get().getName()); //Optional타입이라 .getName()이 바로 안됨
        assertEquals("raccoon@test.com", actualUser.get().getEmail());

    }

    @Test
    void 유효하지_않은_ID_조회_시_비어있는_Optional_반환_테스트() {

        //given: 유효하지 않은 사용자 데이터 설정
        Long invalidId = 999L; //Long타입은 뒤에 L을 붙여야함. 소문자 l은 숫자처럼 보여서 대문자 지향

        //empty(): "비어있는"을 의미
        when(userRepository.findById(invalidId)).thenReturn(Optional.empty());
        //유효하지 않은 사용자의 아이디를 999L로 했는데 굳이 empty로 바꾸는 이유? 그럼 999L은 유효한 값아닌가

        //when
        Optional<User> result = userService.findUserById(invalidId);

        //then: 비어있는 지 검증
        //isPresent(): 존제
        assertFalse(result.isPresent()); //isPresent가 false가 되므로 테스트 통과

    }

    @Test
    void 존재하지_않는_사용자_비활성화_시_예외_발생_테스트() {

        //존재하지 않는 사용자
        Long nonExistId = 999L;
        when(userRepository.findById(nonExistId)).thenReturn(Optional.empty());

        //when
        IllegalArgumentException exception = assertThrows(
                //기대하는 예외 클래스 타입
                IllegalArgumentException.class,
                //예외 발생 메서드
                () -> userService.deactivateUser(nonExistId)
        );

        //then: 검증
        assertEquals("사용자를 찾을 수 없습니다: " + nonExistId, exception.getMessage());

    }

}
