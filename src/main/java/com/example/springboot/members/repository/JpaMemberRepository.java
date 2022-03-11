package com.example.springboot.members.repository;

import com.example.springboot.members.domain.JPAMember;

import java.util.List;
import java.util.Optional;


public interface JpaMemberRepository {
    // 회원등록
    JPAMember save(JPAMember jpaMember);

    // id로 회원조회
    // Optional > 조회시 null처리할때 사용
    Optional<JPAMember> findById(Long id);

    // name으로 회원조회
    Optional<JPAMember> findByName(String name);

    // 전체 회원조회
    List<JPAMember> findAll();

}
