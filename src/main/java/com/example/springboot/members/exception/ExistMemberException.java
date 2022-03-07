package com.example.springboot.members.exception;

import com.example.springboot.global.error.BusinessException;
import com.example.springboot.global.error.ErrorCode;

public class ExistMemberException extends BusinessException {

    public ExistMemberException(ErrorCode errorCode) {
        super(errorCode);
    }
}
