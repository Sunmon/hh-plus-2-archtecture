package com.hhplus.lecture.common;

public class UserException extends RuntimeException {
    private final ErrorCode errorCode;
    private final Long userId;

    public UserException(ErrorCode errorCode, Long userId) {
        this.errorCode = errorCode;
        this.userId = userId;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public Long getUserId() {
        return userId;
    }
}
