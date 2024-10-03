package com.hhplus.lecture.repository;

import com.hhplus.lecture.domain.Schedule;

public interface ScheduleRepository {
    Schedule findById(Long scheduleId);
}
