package com.wanted.servlet.i_filter;

/*comment
*  Filter는 Servlet Container에서 제공하는 특별한 기능이다.
*  HttpRequest / HttpResponse가 발생할 때,
*  가장 먼저 / 가장 나중에 동작하는 기능이다.
*  Filter를 적용하는 방식은 크게 2가지가 있다.
*  1. XML 방식의 등록
*  2. 어노테이션 방식의 등록
*  */

import jakarta.servlet.*;

import java.io.IOException;

public class EncodingFilter implements Filter {

    //XML 방식의 필터 사용하기
    private String encodingType;

    @Override //가장 먼저
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("encoding 필터의 init() 메소드 동작함...");
        encodingType = filterConfig.getInitParameter("encoding-type");
    }

    @Override //실무자
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        /*comment
        *  필터의 핵심 메소드
        *  요청/응답 시 수행해야 하는 일들을 해당 메소드에서 처리한다.
        *  FilterChain은 다음 필터 혹은 필터가 더이상 없다면
        *  요청을 처리할 Servlet으로 향하게 된다.
        *  */
        response.setContentType(encodingType);
        //다음 필터를 호출 or 없다면 Servlet 호출
        chain.doFilter(request, response);
    }

    @Override //종료(파괴)
    public void destroy() {
        System.out.println("encoding filter 파괴됨...");
    }
}
