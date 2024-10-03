package com.hhplus.lecture.common;

import lombok.Getter;

@Getter
public class ScheduleException extends RuntimeException {
    private final ErrorCode errorCode;
    private final Long scheduleId;

    public ScheduleException(ErrorCode errorCode, Long scheduleId) {
        this.errorCode = errorCode;
        this.scheduleId = scheduleId;
    }

}
