package com.example.springboot.members.controller;

import com.example.springboot.members.dto.request.RequestSignUpMemberDto;
import com.example.springboot.members.dto.response.ResponseMemberSelectDto;
import com.example.springboot.members.service.JpaMemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
public class MemberApiController {
    //private final MemberService memberService;
    private final JpaMemberService memberService;

    @GetMapping("/api/members")
    @ResponseBody
    public ResponseEntity<List<ResponseMemberSelectDto>> getMembers() {
        log.info("[GET] /api/members => Get member list");

        return new ResponseEntity<>(memberService.findMembers(), HttpStatus.OK);
    }

    @PostMapping("/api/members")
    @ResponseBody
    public ResponseEntity<Long> signUpMembers(@Validated @RequestBody RequestSignUpMemberDto requestSignUpMemberDto) {
        log.info("[POST] /api/members => Sign-up New member");
        log.info("RequestSignUpMemberDto => " +requestSignUpMemberDto);

        return new ResponseEntity<>(memberService.signUp(requestSignUpMemberDto), HttpStatus.OK);
    }

}
