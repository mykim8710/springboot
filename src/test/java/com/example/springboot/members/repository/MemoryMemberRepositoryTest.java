package com.example.springboot.members.repository;


import com.example.springboot.members.domain.Member;
import com.example.springboot.members.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;


class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    // @AfterEach -> 각 테스트가 종료될 때 마다 이 기능을 실행한다.
    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        // given
        Member member = Member.builder()
                                .name("mykim")
                                .build();

        // when
        repository.save(member);

        // then
        Member result = repository.findById(member.getId()).get();  // optional getValue
        assertThat(member).isEqualTo(result);   // 같은지 비교
    }

    @Test
    public void findByName() {
        // given1
        Member member1 = Member.builder()
                                    .name("mykim1")
                                    .build();
        // when1
        repository.save(member1);

        // given2
        Member member2 = Member.builder()
                                    .name("mykim2")
                                    .build();

        // when2
        repository.save(member2);

        // then
        Member result1 = repository.findByName("mykim1").get();
        Member result2 = repository.findByName("mykim2").get();
        assertThat(member1).isEqualTo(result1);
    }

    @Test
    public void findAll() {
        // given
        Member member1 = Member.builder()
                                    .name("mykim1")
                                    .build();
        repository.save(member1);

        // given
        Member member2 = Member.builder()
                                    .name("mykim2")
                                    .build();
        repository.save(member2);

        // given
        Member member3 = Member.builder()
                                    .name("mykim3")
                                    .build();
        repository.save(member3);

        // then
        List<Member> result = repository.findAll();
        assertThat(result.size()).isEqualTo(3);

    }
}
