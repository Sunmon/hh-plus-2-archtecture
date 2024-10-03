package com.hhplus.lecture.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@ToString
public class LectureException extends RuntimeException {
    private final ErrorCode errorCode;
    private final Long lectureId;
}