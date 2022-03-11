package com.example.springboot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class ViewController {
    // View request
    @GetMapping("/")
    public String indexView() {
        log.info("[GET] / => index Root View");

        return "index";
    }

    @GetMapping("/members")
    public String memberListView() {
        log.info("[GET] /members => member List View");

        return "members/member-list";
    }

    @GetMapping("/members/sign-up")
    public String signUpMemberView() {
        log.info("[GET] /members/sign-up => Sign-up New member View");

        return "members/member-sign-up";
    }
}
