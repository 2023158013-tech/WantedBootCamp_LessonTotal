package com.wanted.docker.menu;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MenuController {

    private final MenuRepository menuRepository;

    //생성자로 의존성 주입(@Autowired 써야 자동 주입: 생성자 하나면 해당 어노테이션 생략 가능)
    public MenuController(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    /* Docker Local 배포 시 Spring Container와 MySQL Container 연동 확인을 위한 HandlerMethod
    *  Docker Network 확인용
    *  */
    @GetMapping("/menus")
    public List<Menu> findAllMenus() {
        return menuRepository.findAll();
    }
}
