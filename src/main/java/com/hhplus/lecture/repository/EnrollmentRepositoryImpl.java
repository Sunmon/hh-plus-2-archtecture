package com.hhplus.lecture.repository;

import com.hhplus.lecture.common.EnrollmentException;
import com.hhplus.lecture.common.ErrorCode;
import com.hhplus.lecture.domain.Enrollment;
import com.hhplus.lecture.domain.Enrollments;
import com.hhplus.lecture.entity.EnrollmentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class EnrollmentRepositoryImpl implements EnrollmentRepository {
    private final EnrollmentJpaRepository enrollmentJpaRepository;

    @Autowired
    public EnrollmentRepositoryImpl(EnrollmentJpaRepository enrollmentJpaRepository) {
        this.enrollmentJpaRepository = enrollmentJpaRepository;
    }

    @Override
    public Enrollment findById(Long enrollmentId) throws EnrollmentException {
        EnrollmentEntity enrollmentEntity = enrollmentJpaRepository.findById(enrollmentId)
                .orElseThrow(() -> new EnrollmentException(ErrorCode.ENROLLMENT_NOT_FOUND, enrollmentId));
        return new Enrollment(enrollmentEntity);
    }

    @Override
    public Enrollment findByScheduleIdAndLectureId(Long scheduleId, Long lectureId) {
        return null;
    }

    @Override
    public Enrollments findByScheduleId(Long scheduleId) {
        return new Enrollments(enrollmentJpaRepository.findByScheduleId(scheduleId)
                .stream()
                .map(Enrollment::new)
                .toList());
    }

    @Override
    public Enrollments findByUserId(Long userId) {
        return new Enrollments(enrollmentJpaRepository.findByUserId(userId)
                .stream()
                .map(Enrollment::new)
                .toList());
    }

    @Override
    public Enrollment insert(Enrollment enrollment) {
        return new Enrollment(enrollmentJpaRepository.insert(enrollment.toEntity()));
    }

}
