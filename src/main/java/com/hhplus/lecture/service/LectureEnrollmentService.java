package com.hhplus.lecture.service;

import com.hhplus.lecture.domain.LectureEnrollment;
import com.hhplus.lecture.repository.LectureEnrollmentRepository;

import java.util.List;

public class LectureEnrollmentService {
    LectureEnrollmentRepository lectureEnrollmentRepository;
    public LectureEnrollmentService(LectureEnrollmentRepository lectureEnrollmentRepository) {
        this.lectureEnrollmentRepository = lectureEnrollmentRepository;
    }

    public List<LectureEnrollment> getLectureEnrollments(Long userId) {
        return lectureEnrollmentRepository.findByUserId(userId).stream()
                .map(enrollmentEntity -> new LectureEnrollment(enrollmentEntity))
                .toList();
    }
}
