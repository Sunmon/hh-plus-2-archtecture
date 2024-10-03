package com.hhplus.lecture.repository;

import com.hhplus.lecture.entity.EnrollmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnrollmentJpaRepository extends JpaRepository<EnrollmentEntity, Long> {
//    List<EnrollmentEntity> findById(Long lectureId);

    //    List<EnrollmentEntity> findByUserId(Long id);
//    Optional<EnrollmentEntity> findById(Long enrollmentId);

    List<EnrollmentEntity> findByScheduleId(Long scheduleId);

    List<EnrollmentEntity> findByUserId(Long userId);

    EnrollmentEntity save(EnrollmentEntity enrollmentEntity);

}
