package com.hhplus.lecture.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;

/**
 * 강의 일정 Entity
 */
@Entity
@Getter
@Table(name = "schedules")
public class ScheduleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "schedule_id")
    private Long id;

    @ManyToOne // 하나의 강의는 여러개의 스케줄을 가질 수 있음
    @JoinColumn(name = "lecture_id")
    private LectureEntity lecture;

    @ManyToOne // 한 강연자는 여러개의 스케쥴을 가질 수 있음
    @JoinColumn(name = "teacher_id")
    private TeacherEntity teacher;

    @Column(columnDefinition = "DATE", name = "schedule_date")
    private LocalDate date;

    public ScheduleEntity(Long scheduleId) {
        this.id = scheduleId;
    }

    public ScheduleEntity(Long scheduleId, LectureEntity lecture, TeacherEntity teacher, LocalDate date) {
        this.id = scheduleId;
        this.lecture = lecture;
        this.teacher = teacher;
        this.date = date;
    }

    public ScheduleEntity() {
    }
}
