package com.example.springboot.members.service;

import com.example.springboot.members.domain.Member;
import com.example.springboot.members.dto.request.RequestSignUpMemberDto;
import com.example.springboot.members.exception.ExistMemberException;
import com.example.springboot.members.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

// spring 컨테이너 없이 최소한의 단위로 잘 나누어 단위 테스트로 진행하는것이 좋음

@SpringBootTest // 스프링 컨테이너와 테스트를 함께 실행한다.
@Transactional  // 테스트 케이스에 이 애노테이션이 있으면, 테스트 시작 전에 트랜잭션을 시작하고, 테스트 완료 후에 항상 롤백한다. 이렇게 하면 DB에 데이터가 남지 않으므로 다음 테스트에 영향을 주지 않는다.
class MemberServiceIntegrationTest {
    @Autowired
    private MemberService service;

    @Autowired
    private MemberRepository repository;

    @Test
    //@Commit >> commit함
    public void 회원가입_테스트() {
        // given  :  ~ 이 주어지고
        RequestSignUpMemberDto requestDto = new RequestSignUpMemberDto();
        requestDto.setName("test");

        // when   :  ~ 이것을 실행했을때
        Long memberId = service.signUp(requestDto);
        System.out.println(memberId);

        // then   :  ~ 결과가 이것이 나와야 된다.
        Member findMember = repository.findById(memberId).get();
        assertEquals(requestDto.getName(), findMember.getName());
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

}