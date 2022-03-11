package com.example.springboot.members.repository;

import com.example.springboot.SpringbootApplication;
import com.example.springboot.members.domain.Member;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class) //Junit4의 Runwith과 같은 기능을 하는 Junit5 어노테이션
@SpringBootTest(classes = SpringbootApplication.class) // Junit5 기준 Application Context사용할 때 사용
class DBMemberRepositoryTest {
    @Autowired
    private SqlSession sqlSession;

    @Test
    @DisplayName("회원저장")    // test 성공 시 지정한 message가 출력
    public void save() {
        // given  :  ~ 이 주어지고
        String name = "abc";
        Member member = Member.builder()
                                .name(name)
                                .build();

        // when   :  ~ 이것을 실행했을때
        sqlSession.insert("saveMember", member);

        // then   :  ~ 결과가 이것이 나와야 된다
        Member result = sqlSession.selectOne("findMemberById", member.getId());

        // 실제값 == 기대값
        assertThat(name).isEqualTo(result.getName());   // 같은지 비교
    }
}