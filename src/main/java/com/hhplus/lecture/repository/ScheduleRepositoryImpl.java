package com.hhplus.lecture.repository;

import com.hhplus.lecture.common.ErrorCode;
import com.hhplus.lecture.common.ScheduleException;
import com.hhplus.lecture.domain.Schedule;
import com.hhplus.lecture.entity.ScheduleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ScheduleRepositoryImpl implements ScheduleRepository {
    final ScheduleJpaRepository scheduleJpaRepository;

    @Autowired
    public ScheduleRepositoryImpl(ScheduleJpaRepository scheduleJpaRepository) {
        this.scheduleJpaRepository = scheduleJpaRepository;
    }

    @Override
    public Schedule findById(Long scheduleId) {
        ScheduleEntity scheduleEntity = scheduleJpaRepository.findById(scheduleId)
                .orElseThrow(() -> new ScheduleException(ErrorCode.SCHEDULE_NOT_FOUND, scheduleId));
        return new Schedule(scheduleEntity);
    }
}
