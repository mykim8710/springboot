package com.example.springboot.members.repository;

import com.example.springboot.members.domain.JPAMember;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
// extends JpaRepository<JPAMember, Long>, JpaMemberRepository : 스프링 데이터 JPA가 SpringDataJpaMemberRepository 를 스프링 빈으로 자동 등록
// 스프링 데이터 JPA 제공 기능 인터페이스를 통한 기본적인 CRUD
// findByName(), findByEmail() 처럼 메서드 이름만으로 조회 기능 제공
// 페이징 기능 자동 제공
public interface SpringDataJpaMemberRepository extends JpaRepository<JPAMember, Long>, JpaMemberRepository {
    // 규칙이 존재, 메서드명, 인자조합
    // JPQL : select m from jpamember m where m.name = ?
    @Override
    Optional<JPAMember> findByName(String name);

    // JPQL : select m from jpamember m where m.name = ? and m.id = ?
    //Optional<JPAMember> findByNameAndId(String name, Long id);

    // JPQL : select m from jpamember m where m.name = ? or m.id = ?
    //Optional<JPAMember> findByNameOrId(String name, Long id);
}
