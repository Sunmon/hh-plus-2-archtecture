package com.hhplus.lecture.common;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum ErrorCode {
    LECTURE_NOT_FOUND("LECTURE_001", "강의를 찾을 수 없습니다."),
    LECTURE_ALREADY_EXISTS("LECTURE_002", "강의가 이미 존재합니다."),
    ENROLLMENT_NOT_FOUND("ENROLLMENT_001", "수강신청을 찾을 수 없습니다."),
    ENROLLMENT_ALREADY_EXISTS("ENROLLMENT_002", "수강신청이 이미 존재합니다."),
    ENROLMENT_LIMIT_EXCEEDED("ENROLLMENT_003", "수강신청 제한을 초과했습니다."),
    SCHEDULE_NOT_FOUND("SCHEDULE_001", "스케줄을 찾을 수 없습니다.");

    private final String code;
    private final String message;
}
