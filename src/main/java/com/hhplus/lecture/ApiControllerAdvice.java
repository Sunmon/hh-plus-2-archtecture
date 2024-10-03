package com.hhplus.lecture;

import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.hhplus.lecture.common.EnrollmentException;
import com.hhplus.lecture.common.LectureException;
import com.hhplus.lecture.common.ScheduleException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
class ApiControllerAdvice extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception e) {
        return ResponseEntity.status(500).body(new ErrorResponse("500", "에러가 발생했습니다."));
    }

    @ExceptionHandler(value = ScheduleException.class)
    public ResponseEntity<ErrorResponse> handleScheduleException(ScheduleException e) {
        return ResponseEntity.status(500).body(new ErrorResponse(e.getErrorCode().toString(), "scheduleId:" + e.getScheduleId()));
    }


    @ExceptionHandler(value = EnrollmentException.class)
    public ResponseEntity<ErrorResponse> handleEnrollmentException(EnrollmentException e) {
        return ResponseEntity.status(500).body(new ErrorResponse(e.getErrorCode().toString(), e.toString()));
    }


    @ExceptionHandler(value = LectureException.class)
    public ResponseEntity<ErrorResponse> handleLectureException(LectureException e) {
        return ResponseEntity.status(500).body(new ErrorResponse(e.getErrorCode().toString(), e.toString()));
    }

    @ExceptionHandler(value = MismatchedInputException.class)
    public ResponseEntity<ErrorResponse> handleMismatchedException(MismatchedInputException e) {
        return ResponseEntity.status(500).body(new ErrorResponse(e.toString(), e.getMessage()));
    }

}