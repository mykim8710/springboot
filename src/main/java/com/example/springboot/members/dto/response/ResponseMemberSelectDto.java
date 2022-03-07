package com.example.springboot.members.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
public class ResponseMemberSelectDto {
    private Long id;
    private String name;
}
