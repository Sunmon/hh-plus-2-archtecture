package com.hhplus.lecture.domain;

import com.hhplus.lecture.entity.ScheduleEntity;

import java.time.LocalDate;

import static com.hhplus.lecture.domain.Lecture.convertToLecture;
import static com.hhplus.lecture.domain.Teacher.convertToTeacher;

public record Schedule(Long id, Lecture lecture, Teacher teacher, LocalDate date) {
    public Schedule(ScheduleEntity scheduleEntity) {
        this(scheduleEntity.getScheduleId(), convertToLecture(scheduleEntity.getLecture()), convertToTeacher(scheduleEntity.getTeacher()), scheduleEntity.getDate());
    }
}
