package com.wanted.crud;

import com.wanted.crud.course.controller.CourseController;
import com.wanted.crud.course.model.service.CourseService;
import com.wanted.crud.course.view.CourseInputView;
import com.wanted.crud.course.view.CourseOutputView;
import com.wanted.crud.global.config.JDBCTemplate;

import java.sql.Connection;
import java.sql.SQLException;

public class Application {
    public static void main(String[] args) {

        try (Connection con = JDBCTemplate.getConnection()) {
            System.out.println("✅ 데이터베이스 연결 성공!!!");
             JDBCTemplate.printConnectionStatus();

             /*comment
             *  request(요청) 시
             *  Application -> CourseInputView(클라이언트 입력창) -> CourseController(입력에 따른 동작) -> CourseService
             *  -> CourseDAO(데이터 액세스 객체) -> MySQL(RDBMS)
             *  response(응답) 시
             *  역순이다. 다만 CourseOutputView를 통해 결과물을 보여줄 것이다.*/

            /**
             * 문서화 주석
             * @deprecated 현재 아래에 작성될 코드는 나중에는 사라지는 코드(레거시 코드)
             * 객체 조립 진행
             * */
            CourseService service = new CourseService(con);
            CourseController controller = new CourseController(service);
            CourseOutputView outputView = new CourseOutputView();
            CourseInputView inputView = new CourseInputView(controller, outputView);

            /*Application이 실행되면 View 메소드를 호출한다.*/
            inputView.displayMainMenu();

        } catch (SQLException e) {
            System.err.println("🚨 데이터베이스 연결 실패...");
        } finally {
            JDBCTemplate.close();
        }
    }
}
