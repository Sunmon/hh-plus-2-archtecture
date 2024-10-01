package com.hhplus.lecture.repository;

import com.hhplus.lecture.entity.LectureEnrollmentEntity;

import java.util.List;

public interface LectureEnrollmentRepository {
    List<LectureEnrollmentEntity> findById(Long lectureId);
    List<LectureEnrollmentEntity> findByUserId(Long userId);
}
