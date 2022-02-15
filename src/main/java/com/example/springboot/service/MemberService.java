package com.example.springboot.service;

import com.example.springboot.domain.Member;
import com.example.springboot.dto.request.RequestMemberDto;
import com.example.springboot.dto.response.ResponseMemberDto;
import com.example.springboot.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//@RequiredArgsConstructor
//@Service
public class MemberService {

    private final MemberRepository memberRepository;

    // DI : Dependency Injection 의존성주입
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /* 회원가입 */
    public Long signUp(RequestMemberDto dto) {
        validateDuplicateMember(dto); // 중복회원 검증

        Member member = Member.builder()
                                    .name(dto.getName())
                                    .build();
        memberRepository.save(member);

        return member.getId();
    }

    /* 전체 회원조회 */
    public List<ResponseMemberDto> findMembers() {
        List<ResponseMemberDto> members =  new ArrayList<>();

        members.addAll(memberRepository.findAll()
                                            .stream()
                                            .map(Member -> Member.toResponseMemberDto())
                                            .collect(Collectors.toList()));

        return members;
    }

    /* id로 회원조회 */
    public ResponseMemberDto findOne(Long memberId) {
        Member member = memberRepository.findById(memberId)
                                            .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));

        return member.toResponseMemberDto();
    }

    private void validateDuplicateMember(RequestMemberDto dto) {
        // 만약 값이 있다면 == not null Optional이기에  가능
        memberRepository.findByName(dto.getName())
                .ifPresent(member -> {
                    throw new IllegalArgumentException("이미 존재하는 회원입니다.");
                });
    }
}
