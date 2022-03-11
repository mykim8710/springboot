package com.example.springboot.members.domain;

import com.example.springboot.members.dto.response.ResponseMemberSelectDto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Builder
@Getter
@Setter
@ToString
public class Member {
    private Long id;       // sequence
    private String name;

    public ResponseMemberSelectDto toResponseMemberDto() {
        return ResponseMemberSelectDto.builder()
                                    .id(id)
                                    .name(name)
                                        .build();
    }
}
