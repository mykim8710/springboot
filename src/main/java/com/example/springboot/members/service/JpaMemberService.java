package com.example.springboot.members.service;

import com.example.springboot.global.error.ErrorCode;
import com.example.springboot.members.domain.JPAMember;
import com.example.springboot.members.domain.Member;
import com.example.springboot.members.dto.request.RequestSignUpMemberDto;
import com.example.springboot.members.dto.response.ResponseMemberSelectDto;
import com.example.springboot.members.exception.ExistMemberException;
import com.example.springboot.members.repository.JpaMemberRepository;
import com.example.springboot.members.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
@Transactional // JPA를 통한 모든 데이터 변경은 트랜잭션 안에서 실행해야 한다.
public class JpaMemberService {
    private final JpaMemberRepository jpaMemberRepository;

    /* 회원가입 */
    public Long signUp(RequestSignUpMemberDto dto) {
        validateDuplicateMember(dto); // 중복회원 검증

        JPAMember jpaMember = JPAMember.builder()
                                    .name(dto.getName())
                                    .build();
        jpaMemberRepository.save(jpaMember);

        return jpaMember.getId();
    }

    /* 전체 회원조회 */
    public List<ResponseMemberSelectDto> findMembers() {
        List<ResponseMemberSelectDto> members =  new ArrayList<>();

        members.addAll(jpaMemberRepository.findAll()
                                            .stream()
                                            .map(JPAMember -> JPAMember.toResponseMemberDto())
                                            .collect(Collectors.toList()));

        return members;
    }

    /* id로 회원조회 */
    public ResponseMemberSelectDto findMemberOne(Long memberId) {
        JPAMember jpaMember = jpaMemberRepository.findById(memberId)
                                            .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));

        return jpaMember.toResponseMemberDto();
    }

    private void validateDuplicateMember(RequestSignUpMemberDto dto) {
        // 만약 값이 있다면 == not null Optional임으로  가능
        jpaMemberRepository.findByName(dto.getName())
                .ifPresent(member -> {
                    throw new ExistMemberException(ErrorCode.EXIST_MEMBER);
                });
    }
}
