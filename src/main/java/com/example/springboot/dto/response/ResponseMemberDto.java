package com.example.springboot.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
public class ResponseMemberDto {
    private Long id;
    private String name;
}
