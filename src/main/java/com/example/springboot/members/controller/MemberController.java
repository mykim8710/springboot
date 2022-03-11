package com.example.springboot.members.controller;

import com.example.springboot.members.dto.request.RequestSignUpMemberDto;
import com.example.springboot.members.dto.response.ResponseMemberSelectDto;
import com.example.springboot.members.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Controller
public class MemberController {
    private final MemberService memberService;

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

    // REST API
    @GetMapping("/api/members")
    @ResponseBody
    public ResponseEntity<List<ResponseMemberSelectDto>> getMembers() {
        log.info("[GET] /api/members => get member list");

        return new ResponseEntity<>(memberService.findMembers(), HttpStatus.OK);
    }

    @PostMapping("/api/members")
    @ResponseBody
    public ResponseEntity<Long> signUpMembers(@RequestBody RequestSignUpMemberDto requestSignUpMemberDto) {
        log.info("[POST] /api/members => Sign-up New member");
        log.info("RequestSignUpMemberDto => " +requestSignUpMemberDto);

        return new ResponseEntity<>(memberService.signUp(requestSignUpMemberDto), HttpStatus.OK);
    }


    
}
