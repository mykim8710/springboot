package com.example.springboot.members.repository;

import com.example.springboot.members.domain.Member;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
//@Repository
public class MyBatisMemberRepositoryImpl implements MemberRepository {
    private final SqlSession sqlSession;

    @Override
    public Member save(Member member) {
        sqlSession.insert("saveMember", member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        Member member = sqlSession.selectOne("findMemberById" ,id);
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findByName(String name) {
        Member member = sqlSession.selectOne("findMemberByName", name);

        return Optional.ofNullable(member);
    }

    @Override
    public List<Member> findAll() {
        return sqlSession.selectList("findAllMember");
    }
}
