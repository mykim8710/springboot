package com.example.springboot.members.service;

import com.example.springboot.members.domain.Member;
import com.example.springboot.members.dto.request.RequestSignUpMemberDto;
import com.example.springboot.members.dto.response.ResponseMemberSelectDto;
import com.example.springboot.members.exception.ExistMemberException;
import com.example.springboot.global.error.ErrorCode;
import com.example.springboot.members.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository;

//    @Autowired
//    public MemberService(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }

    /* 회원가입 */
    public Long signUp(RequestSignUpMemberDto dto) {
        validateDuplicateMember(dto); // 중복회원 검증

        Member member = Member.builder()
                                    .name(dto.getName())
                                    .build();
        memberRepository.save(member);

        return member.getId();
    }

    /* 전체 회원조회 */
    public List<ResponseMemberSelectDto> findMembers() {
        List<ResponseMemberSelectDto> members =  new ArrayList<>();

        members.addAll(memberRepository.findAll()
                                            .stream()
                                            .map(Member -> Member.toResponseMemberDto())
                                            .collect(Collectors.toList()));

        return members;
    }

    /* id로 회원조회 */
    public ResponseMemberSelectDto findOne(Long memberId) {
        Member member = memberRepository.findById(memberId)
                                            .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));

        return member.toResponseMemberDto();
    }

    private void validateDuplicateMember(RequestSignUpMemberDto dto) {
        // 만약 값이 있다면 == not null Optional임으로  가능
        memberRepository.findByName(dto.getName())
                .ifPresent(member -> {
                    throw new ExistMemberException(ErrorCode.EXIST_MEMBER);
                });
    }
}
