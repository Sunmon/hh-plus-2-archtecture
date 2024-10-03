package com.hhplus.lecture.domain;

import com.hhplus.lecture.entity.ScheduleEntity;

import java.time.LocalDate;

public record Schedule(Long id, Lecture lecture, Teacher teacher, LocalDate date, int remain) {
    public Schedule(ScheduleEntity scheduleEntity) {
        this(scheduleEntity.getId(), Lecture.fromEntity(scheduleEntity.getLecture()), Teacher.fromEntity(scheduleEntity.getTeacher()), scheduleEntity.getDate(), 0);
    }

    public static Schedule fromEntity(ScheduleEntity scheduleEntity) {
        return new Schedule(scheduleEntity);
    }

//    public static Schedule toEntity(Shedule scheduleEntity) {
//        return new Schedule(scheduleEntity);
//    }

    public static ScheduleEntity toEntity(Schedule schedule) {
        return new ScheduleEntity(schedule.id(), Lecture.toEntity(schedule.lecture()), Teacher.toEntity(schedule.teacher()), schedule.date());
    }

    public ScheduleEntity toEntity() {
        return new ScheduleEntity(this.id(), Lecture.toEntity(this.lecture()), Teacher.toEntity(this.teacher()), this.date());
    }

    public Schedule withRemainCount(int count) {
        return new Schedule(this.id(), this.lecture(), this.teacher(), this.date(), count);
    }


}
