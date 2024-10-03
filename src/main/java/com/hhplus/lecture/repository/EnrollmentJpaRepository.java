package com.hhplus.lecture.repository;

import com.hhplus.lecture.domain.Enrollment;
import com.hhplus.lecture.entity.EnrollmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import java.util.List;

import static jakarta.persistence.LockModeType.PESSIMISTIC_READ;
import static jakarta.persistence.LockModeType.PESSIMISTIC_WRITE;

public interface EnrollmentJpaRepository extends JpaRepository<EnrollmentEntity, Long> {

    @Lock(PESSIMISTIC_READ)
    List<EnrollmentEntity> findByScheduleId(Long scheduleId);

    @Lock(PESSIMISTIC_READ)
    List<EnrollmentEntity> findByUserId(Long userId);

    @Lock(PESSIMISTIC_WRITE)
    Enrollment save(Enrollment enrollment);

}
