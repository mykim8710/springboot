package com.example.springboot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class HomeController {
    // View request
    @GetMapping("/")
    public String indexView() {
        log.info("[GET] / => index Root View");

        return "index";
    }
}
