package com.example.springboot.domain;

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
}
