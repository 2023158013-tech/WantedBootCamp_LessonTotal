package com.wanted.servlet.g_redirect;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/othersite")
public class OtherSiteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("get 요청 수락함");
        System.out.println(resp);
        /*comment
        *  sendRedirect를 하고 network 탭을 확인하면 302번 코드와 함께
        *  naver 사이트로 이동하는 것을 볼 수 있다.
        *  redirect는 사용자 url 재작성이라고 불리며 강제로 사용자의 url을 변경하여
        *  경로를 이동시키는 역할을 하게 된다.
        *  */
        resp.sendRedirect("https://www.naver.com");
    }
}
