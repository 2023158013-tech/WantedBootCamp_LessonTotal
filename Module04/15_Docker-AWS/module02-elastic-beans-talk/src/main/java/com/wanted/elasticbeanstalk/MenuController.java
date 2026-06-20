package com.wanted.elasticbeanstalk;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MenuController {

    private final MenuRepository menuRepository;

    @GetMapping("/health") //실시간 배포 확인용
    public String check() {
        return "Cloud 배포 Test V_1.0.0";
    }

    @GetMapping("/menus/{menuCode}") //RDS 접근 확인용
    public Menu findMenuByMenuCode(@PathVariable int menuCode) {

        return menuRepository.findByMenuCode(menuCode);
    }
}
