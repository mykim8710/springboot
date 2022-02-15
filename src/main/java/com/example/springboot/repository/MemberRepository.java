package com.example.springboot.repository;

import com.example.springboot.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    // 회원등록
    Member save(Member member);

    // id로 회원조회
    Optional<Member> findById(Long id);

    // name으로 회원조회
    Optional<Member> findByName(String name);

    // 전체 회원조회
    List<Member> findAll();

}
