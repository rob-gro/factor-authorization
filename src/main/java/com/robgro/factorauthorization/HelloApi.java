package com.robgro.factorauthorization;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// 14. dodajemy end pointy
@RestController
public class HelloApi {

    @GetMapping("/hello")
    public String hello() {
        return "hello from Hello API";
    }
}
