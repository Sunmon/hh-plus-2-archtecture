package com.hhplus.lecture.dto;

import com.hhplus.lecture.domain.Enrollment;

public record EnrollmentResponseDTO(Long scheduleId, Long lectureId, Long userId) {
    public EnrollmentResponseDTO(Enrollment enrollment) {
        this(enrollment.schedule().id(), enrollment.schedule().lecture().id(), enrollment.user().id());
    }
}

