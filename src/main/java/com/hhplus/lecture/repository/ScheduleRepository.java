package com.hhplus.lecture.repository;

import com.hhplus.lecture.domain.Schedule;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface ScheduleRepository {
    Schedule findById(Long scheduleId);

    List<Schedule> findAll();

    Map<LocalDate, List<Schedule>> findAllGroupInDate();

}
