package com.example.springboot.service;

import com.example.springboot.dto.request.RequestMemberDto;
import com.example.springboot.dto.response.ResponseMemberDto;
import com.example.springboot.repository.MemoryMemberRepository;
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
        // given  ~~ 가 주어지고
        RequestMemberDto requestDto = new RequestMemberDto();
        requestDto.setName("mykim");

        // when   ~~ 이것을 실행했을때
        Long memberId = service.signUp(requestDto);
        System.out.println(memberId);

        // then   ~~ 결과가 이것이 나와야 된다.
        ResponseMemberDto expectedDto = service.findOne(memberId);
        assertThat("mykim").isEqualTo(expectedDto.getName());
    }

    @Test
    public void 중복회원예외_테스트() {
        // given  ~~ 가 주어지고
        RequestMemberDto requestDto = new RequestMemberDto();
        requestDto.setName("mykim");

        RequestMemberDto requestDto2 = new RequestMemberDto();
        requestDto2.setName("mykim");

        // when   ~~ 이것을 실행했을때
        service.signUp(requestDto);

        // service.signUp(requestDto2) 로직이 실행되면 IllegalArgumentException 이 예외가 터져야한다.
        /*try {
            service.signUp(requestDto2);    // Exception 발생(중복이름으로 인한 exception)
            fail();
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        }*/
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> service.signUp(requestDto2));

        // then   ~~ 결과가 이것이 나와야 된다.
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
    }


    @Test
    public void 전체회원조회_테스트() {
        // given  ~~ 가 주어지고

        // when   ~~ 이것을 실행했을때

        // then   ~~ 결과가 이것이 나와야 된다.
    }

    @Test
    public void id로회원조회_테스트() {
        // given  ~~ 가 주어지고

        // when   ~~ 이것을 실행했을때

        // then   ~~ 결과가 이것이 나와야 된다.
    }
}