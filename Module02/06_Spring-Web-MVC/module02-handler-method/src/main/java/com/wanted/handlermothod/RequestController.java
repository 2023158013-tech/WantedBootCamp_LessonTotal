package com.wanted.handlermothod;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

@Controller
@SessionAttributes("id")
@RequestMapping("/request/*")
public class RequestController {

    /*comment
    *  view 페이지를 보여주는 방식은 여러가지가 있다.
    *  1. String 타입의 반환값으로 view 이름을 작성
    *  2. 메서드의 타입을 void로 하게 되면
    *  -요청 url이 view의 이름이 된다.*/
    @GetMapping("regist")
    public void regist() {}

    @PostMapping("regist")
    public String registMenu(Model model, WebRequest request) {

        String menuName = request.getParameter("name");
        int menuPrice = Integer.parseInt(request.getParameter("price"));
        int categoryCode = Integer.parseInt(request.getParameter("categoryCode"));

        String message = menuName + "을(를) 신규 메뉴 목록 " + categoryCode +
                "번 카테고리에 " + menuPrice + " 원으로 등록 성공했습니다!";

        model.addAttribute("message", message);

        return "request/printResult";
    }

    @GetMapping("modify")
    public void modify() {}

    /*comment
    *  @RequestParam은 req에 들어있는 변수를 쉽게 꺼낼 쓸 수 있는 어노테이션.
    *  주의!: view의 name 속성과 일치하게 작성해야 400 error 발생이 안되며
    *  만약 name 속성과 일치하고 싶지 않으면 이름을 명시해야 한다.
    *  */
    @PostMapping("modify")
    public String modifyMenu(Model model, @RequestParam("modifyName") String name,
                             @RequestParam(name = "modifyPrice", required = false, defaultValue = "0") int price) {
        String message = name + "의 가격을 " + price + "로 수정!";

        model.addAttribute("message", message);

        return "request/printResult";
    }

    @PostMapping("modifyAll")
    public String modifyAll(Model model, @RequestParam Map<String, String> parameters) {

        String menuName = parameters.get("modifyName2");
        int price = Integer.parseInt(parameters.get("modifyPrice2"));

        String message = menuName + "의 가격을 " + price + "로 수정!";
        model.addAttribute("message", message);

        return "request/printResult";
    }

    @GetMapping("search")
    public void search() {}

    /*comment
    *  위쪽에서 @RequestParam으로 요청 시 값을 받아오게 되면
    *  나중에 전달받을 값이 많아지는 경우에 관리해야 할 변수, 키값이 많아진다.
    *  @ModelAttribute는 클래스 자료형을 활용하여 여러 값을 한 번에
    *  받아올 수 있는 기능을 제공한다.
    *  (이름이 중요!)
    *  Model 객체에 addAttribute를 하지 않아도 네이밍 규칙에 의해 사용할 수 있다.
    *  ex) @ModelAttribute("menu") -> view에서 menu 이름으로 값 사용
    *  ex) @ModelAttribute -> view에서 menuDTO 이름으로 값 사용
    *  */
    @PostMapping("search")
    public String searchMenu(Model model, @ModelAttribute("menu") MenuDTO menu) {

        System.out.println("model = " + model);

        return "request/searchResult";
    }

    @GetMapping("login")
    public void login() {}

    /*HttpSession 객체를 활용*/
    @PostMapping("login1")
    public String sessionTest(HttpSession session, @RequestParam String id) {
        session.setAttribute("id", id);

        return "request/loginResult";
    }

    @GetMapping("logout1")
    public String sessionInvalidate(HttpSession session) {
        //세션 만료 메서드
        session.invalidate();
        return "request/loginResult";
    }

    /*comment
    *  @SessionAttributes를 이용해서 session에 값 담기
    *  @SessionAttributes -> 클래스 레벨에 작성한다. (클래스 선언 제일 위)
    *  session에 담을 Key값을 설정해두면 Model 영역에 해당하는 Key로 값이 추가되는 경우,
    *  자동으로 session에 등록해준다.
    *  */
    @PostMapping("login2")
    public String sessionTest2(Model model, @RequestParam String id) {
        model.addAttribute("id", id);

        return "request/loginResult";
    }

    /*comment
    *  SessionAttribute 방식은 Servlet에서 Session을 만료시키는 invalidate() 메서드로는 할 수 없다.
    *  SessionStatus 객체의 setComplete() 메소드를 사용해야 만료시킬 수 있다.
    *  */
    @GetMapping("logout2")
    public String sessionComplete(SessionStatus sessionStatus) {
        //세션 만료 메서드
        sessionStatus.setComplete();
        return "request/loginResult";
    }
}
