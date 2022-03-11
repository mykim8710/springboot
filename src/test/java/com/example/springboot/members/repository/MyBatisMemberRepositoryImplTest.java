package com.example.springboot.members.repository;

import com.example.springboot.members.domain.Member;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest // 스프링 컨테이너와 테스트를 함께 실행한다.
@Transactional  // 테스트 케이스에 이 애노테이션이 있으면, 테스트 시작 전에 트랜잭션을 시작하고, 테스트 완료 후에 항상 롤백한다. 이렇게 하면 DB에 데이터가 남지 않으므로 다음 테스트에 영향을 주지 않는다.
class MyBatisMemberRepositoryImplTest {
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