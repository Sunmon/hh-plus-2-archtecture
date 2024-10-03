package com.hhplus.lecture.dto;

import com.hhplus.lecture.domain.Enrollment;
import com.hhplus.lecture.domain.Lecture;
import com.hhplus.lecture.domain.Teacher;

public record EnrollmentResponseDTO(Long scheduleId, Lecture lecture, Teacher teacher) {
    public EnrollmentResponseDTO(Enrollment enrollment) {
        this(enrollment.schedule().id(), enrollment.schedule().lecture(), enrollment.schedule().teacher());
    }
}
