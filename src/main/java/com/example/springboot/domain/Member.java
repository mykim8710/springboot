package com.example.springboot.domain;

import com.example.springboot.dto.response.ResponseMemberDto;
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

    public ResponseMemberDto toResponseMemberDto() {
        return ResponseMemberDto.builder()
                                    .id(id)
                                    .name(name)
                                        .build();
    }
}
