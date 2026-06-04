package com.wanted.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/*comment
*  인터셉터를 구현하기 위해서는 HandlerInterceptor를 상속받아야 한다.
*  해당 클래스는 Interceptor로 등록이 되며 컨트롤러의 실행 전/후를
*  가로챌 수 있는 권한을 가지게 된다.
*  */

@Component
public class StopWatchInterceptor implements HandlerInterceptor {

    /*comment
    *  preHandle: 전처리의 의미
    *  컨트롤러의 핸들러 메서드가 동작하기 전에 호출된다.
    *  */
    @Override //pre 이전
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        System.out.println("preHandle 메서드 호출됨...");

        long startTime = System.currentTimeMillis();

        request.setAttribute("startTime", startTime);

        //true: 컨트롤러의 핸들러 메서드를 이어서 호출한다.
        //false: 컨트롤러의 핸들러 메서드를 호출하지 않는다.
        return true; //메서드 타입이 불린이라서 true로 설정(컨트롤러로 지나감)
    }

    //여기 사이에 controller가 끼어 있음⇅

    /*comment
     *  postHandle: 후처리의 의미
     *  컨트롤러의 핸들러 메서드가 동작한 후에 호출된다.
     *  */
    @Override //post 이후
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {

        System.out.println("postHandler 호출됨...");

        //int(기본값: 0) - Integet(기본값: null)

        long startTime = (Long) request.getAttribute("startTime");
        request.removeAttribute("startTime");

        long endTime = System.currentTimeMillis();

        //interval = endTime - startTime
        modelAndView.addObject("interval", endTime - startTime);

    }
}
