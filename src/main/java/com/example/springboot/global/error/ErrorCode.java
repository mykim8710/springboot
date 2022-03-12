package com.example.springboot.global.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public enum ErrorCode {

    //Sign-up Error
    EXIST_MEMBER(400, "S001", "This member is exist."),

    // Validation Error
    NOT_BLANK(400, "V001", ""),
    ;


    private int status;
    private String code;
    private String message;
}
