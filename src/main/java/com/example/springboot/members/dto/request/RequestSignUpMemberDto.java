package com.example.springboot.members.dto.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@ToString
public class RequestSignUpMemberDto {
    @NotBlank(message = "This is required!!")
    private String name;
}
