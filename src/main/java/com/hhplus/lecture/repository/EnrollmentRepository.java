package com.hhplus.lecture.repository;

import com.hhplus.lecture.common.EnrollmentException;
import com.hhplus.lecture.domain.Enrollment;
import com.hhplus.lecture.domain.Enrollments;

public interface EnrollmentRepository {
    Enrollment findById(Long enrollmentId) throws EnrollmentException;

    Enrollment findByScheduleIdAndLectureId(Long scheduleId, Long lectureId);

    Enrollments findByScheduleId(Long scheduleId);

    Enrollments findByUserId(Long userId);

    Enrollment insert(Enrollment enrollment);
}
