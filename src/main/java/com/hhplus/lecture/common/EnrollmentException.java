package com.hhplus.lecture.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@ToString
public class EnrollmentException extends RuntimeException {
    private final ErrorCode errorCode;
    private final Long enrollmentId;
    private Long userId;
    private Long lectureId;


    public EnrollmentException(ErrorCode errorCode, Long enrollmentId, Long userId, Long lectureId) {
        this.errorCode = errorCode;
        this.enrollmentId = enrollmentId;
        this.userId = userId;
        this.lectureId = lectureId;
    }
}
