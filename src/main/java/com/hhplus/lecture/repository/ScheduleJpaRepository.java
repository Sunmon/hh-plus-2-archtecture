package com.hhplus.lecture.repository;

import com.hhplus.lecture.entity.ScheduleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ScheduleJpaRepository extends JpaRepository<ScheduleEntity, Long> {

    Optional<ScheduleEntity> findById(Long scheduleId);
}
