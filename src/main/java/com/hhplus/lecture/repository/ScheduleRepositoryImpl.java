package com.hhplus.lecture.repository;

import com.hhplus.lecture.common.ErrorCode;
import com.hhplus.lecture.common.ScheduleException;
import com.hhplus.lecture.domain.Schedule;
import com.hhplus.lecture.entity.ScheduleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class ScheduleRepositoryImpl implements ScheduleRepository {
    final ScheduleJpaRepository scheduleJpaRepository;

    @Autowired
    public ScheduleRepositoryImpl(ScheduleJpaRepository scheduleJpaRepository) {
        this.scheduleJpaRepository = scheduleJpaRepository;
    }

    @Override
    public Schedule findById(Long scheduleId) throws ScheduleException {
//        ScheduleEntity scheduleEntity = scheduleJpaRepository.findByScheduleId(scheduleId)
        ScheduleEntity scheduleEntity = scheduleJpaRepository.findById(scheduleId)
                .orElseThrow(() -> new ScheduleException(ErrorCode.SCHEDULE_NOT_FOUND, scheduleId));
        return new Schedule(scheduleEntity);
    }

    @Override
    public List<Schedule> findAll() {
        return scheduleJpaRepository.findAll().stream().map(Schedule::new).toList();
    }

    @Override
    public Map<LocalDate, List<Schedule>> findAllGroupInDate() {
        return findAll().stream().collect(Collectors.groupingBy(Schedule::date));
    }

}
