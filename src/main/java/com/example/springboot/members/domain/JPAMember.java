package com.example.springboot.members.domain;

import com.example.springboot.members.dto.response.ResponseMemberSelectDto;
import lombok.*;

import javax.persistence.*;


// JPA(Java Persistance API) : 자바진영의 ORM 표준기술, API 표준명세
// ORM(Object Relational Mapping) : 객체-관계형 데이터베이스를 맵핑
// 객체와 테이블을 맵핑
// Hibernate : ORM 프레임워크 중 하나, 거의 대부분의 패러다임의 불일치 문제를 해결해주는 성숙한 ORM 프레임워크

@Entity                     // 맵핑정보, 해당 클래스(JPAMember)를 테이블(MEMBER)과 맵핑하겠다고 JPA에 알려줌
@Table(name="JPAMEMBER")	// 맵핑정보, 엔티티 클래스에 맵핑할 테이블 정보(name, Table name 속성 사용)

@Getter
@Setter
@ToString
public class JPAMember {
    @Id                 // 맵핑정보, 엔티티클래스의 필드를 테이블의 pk에 맵핑, 식별자 필드
    @Column(name="ID")	// 맵핑정보, 해당되는 컬럼에 맵핑
    @GeneratedValue(strategy = GenerationType.IDENTITY) // DB가 알아서 pk생성
    private Long id;       // sequence

    @Column(name="NAME")	// 맵핑정보, 해당되는 컬럼에 맵핑
    private String name;

    public JPAMember(){}

    @Builder
    public JPAMember(String name) {
        this.name = name;
    }

    public ResponseMemberSelectDto toResponseMemberDto() {
        return ResponseMemberSelectDto.builder()
                .id(id)
                .name(name)
                .build();
    }
}
