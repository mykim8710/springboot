package com.example.springboot.members.repository;

import com.example.springboot.members.domain.Member;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class DBMemberRepository implements MemberRepository {
    private final SqlSession sqlSession;

//    @Autowired
//    public DBMemberRepository(SqlSession sqlSession) {
//        this.sqlSession = sqlSession;
//    }

    @Override
    public Member save(Member member) {
        sqlSession.insert("save", member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Member> findByName(String name) {
        Member member = sqlSession.selectOne("findByName", name);

        return Optional.ofNullable(member);
    }

    @Override
    public List<Member> findAll() {
        return null;
    }
}
