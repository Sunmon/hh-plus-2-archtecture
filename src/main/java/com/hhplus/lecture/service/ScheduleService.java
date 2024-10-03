package com.hhplus.lecture.service;

import com.hhplus.lecture.common.ScheduleException;
import com.hhplus.lecture.domain.Schedule;
import com.hhplus.lecture.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;

    @Autowired
    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    public Schedule getSchedule(Long scheduleId) throws ScheduleException {
        return scheduleRepository.findById(scheduleId);
    }
}
