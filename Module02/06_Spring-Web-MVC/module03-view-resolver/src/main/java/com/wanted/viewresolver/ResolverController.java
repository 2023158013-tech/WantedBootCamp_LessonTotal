package com.wanted.viewresolver;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ResolverController {

    @GetMapping("string")
    //HttpResponse -> Model, HttpRequest -> @RequestParam, @ModelRequest?
    public String stringView(Model model) {
        model.addAttribute("forwardMessage", "문자열로 뷰 이름 반환");

        /*comment
        *  @Controller에서 문자열 return의 의미는 반환 후 ThymeleafViewResolver에게
        *  resources/templates/ 를 prefix로 .html을 suffix로 하겠다는 의미이다.
        *  아래 리턴값은 실제로 resources/templates/result.html의 의미로 해석된다.
        *  */

        return "result"; //return하면 컨트롤러의 역할이 끝나며 templates 속 result.html 파일로 넘어감.
    }

    @GetMapping("string-redirect")
    public String stringRedirect() {
        /*comment
        *  View 리턴 시 기본 방식은 forward이다.
        *  redirect가 필요하면 접두사 redirect:{보낼 url}
        *  이렇게 작성해주면 된다.*/
        return "redirect:/"; //send redirect의 축약
    }

    @GetMapping("string-redirect-attr")
    public String stringRedirectAttr(RedirectAttributes rttr) {

        /*comment
        *  redirect 시에는 재요청이 발생한다.
        *  그렇기 때문에 최초에 model에 담아둔 test값은 재요청 시소멸된다.
        *  우리는 redirect 시 저장한 값을 응답하기 위해서
        *  session, cookie 개념을 배웠었다.
        *  spring에서는 RedirectAttributes라는 타입을 통해
        *  redirect를 하더라도 값을 저장할 수 있는 방법을 제공해준다.
        *  */
//        model.addAttribute("test", "test");
        //redirect 시 유지하고 싶은 값
        /*comment
        *  flashAttribute는 세션에 임시로 값을 담아두고 자동 소멸하는 방식이기 때문에
        *  session, cookie를 사용하는 것보다 훨씬 메모리적으로 유리하다.
        *  */
        rttr.addFlashAttribute("flashMessage", "리다이렉트 시 유지되는 값!");

        return "redirect:/";
    }

    @GetMapping("modelAndView")
    public ModelAndView modelAndView(ModelAndView mv) {

        mv.addObject("forwardMessage", "ModelAndView를 이용한 값과 뷰 반환");
        mv.setViewName("result");

        return mv;
    }

    /*comment
    *  Spring에서 @Controller는 View를 반환해야 하는 책임을 가진다.
    *  View를 반환하는 방법은 크게 3가지가 있다.
    *  1. void -> 요청 url이 view 경로가 됨.
    *  2. String -> 문자열 리턴값이 view 경로가 됨.
    *  3. ModelAndView -> SetViewName(문자열) 문자열이 view 경로가 됨.
    *  */

}
