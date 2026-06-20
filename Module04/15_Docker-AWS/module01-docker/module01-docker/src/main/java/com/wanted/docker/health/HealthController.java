package com.wanted.docker.health;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HealthController {

    /*Application의 동작 여부를 판단하는 HandlerMethod*/
    @GetMapping("/health")
    public Map<String, String> health() {
        return Map.of("status", "나 살아있다.");
    }
}
