package com.example.springboot.service;

import com.example.springboot.members.dto.request.RequestSignUpMemberDto;
import com.example.springboot.members.dto.response.ResponseMemberSelectDto;
import com.example.springboot.members.exception.ExistMemberException;
import com.example.springboot.members.repository.MemoryMemberRepository;
import com.example.springboot.members.service.MemberService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {
    MemberService service;
    MemoryMemberRepository repository;

    // @BeforeEach -> 각 테스트가 실행 전에 해당 로직을 수행
    @BeforeEach
    public void beforeEach() {
        repository = new MemoryMemberRepository();
        service = new MemberService(repository);
    }

    // @AfterEach -> 각 테스트가 종료될 때 해당 기능을 수행
    @AfterEach
    public void afterEach() {
        repository.clearStore();    // memory clear
    }

    @Test
    public void 회원가입_테스트() {
        // given  :  ~ 이 주어지고
        RequestSignUpMemberDto requestDto = new RequestSignUpMemberDto();
        requestDto.setName("mykim");

        // when   :  ~ 이것을 실행했을때
        Long memberId = service.signUp(requestDto);
        System.out.println(memberId);

        // then   :  ~ 결과가 이것이 나와야 된다.
        ResponseMemberSelectDto expectedDto = service.findOne(memberId);
        assertThat("mykim").isEqualTo(expectedDto.getName());
    }

    @Test
    public void 중복회원예외_테스트() {
        // given  :  ~ 이 주어지고
        RequestSignUpMemberDto requestDto = new RequestSignUpMemberDto();
        requestDto.setName("mykim");

        RequestSignUpMemberDto requestDto2 = new RequestSignUpMemberDto();
        requestDto2.setName("mykim");

        // when   :  ~ 이것을 실행했을때
        service.signUp(requestDto);

        // service.signUp(requestDto2) 로직이 실행되면 IllegalArgumentException 이 예외가 터져야한다.
        ExistMemberException e = assertThrows(ExistMemberException.class, () -> service.signUp(requestDto2));

        // then   :  ~ 결과가 이것이 나와야 된다.
        assertThat(e.getMessage()).isEqualTo("This member is exist.");
    }


    @Test
    public void 전체회원조회_테스트() {
        // given  :  ~ 이 주어지고


        // when   :  ~ 이것을 실행했을때


        // then   :  ~ 결과가 이것이 나와야 된다
    }

    @Test
    public void id로회원조회_테스트() {
        // given  :  ~ 이 주어지고


        // when   :  ~ 이것을 실행했을때


        // then   :  ~ 결과가 이것이 나와야 된다
    }
}