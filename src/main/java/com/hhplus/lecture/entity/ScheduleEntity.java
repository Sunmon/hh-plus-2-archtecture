package com.hhplus.lecture.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;

@Entity
@Getter
public class ScheduleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scheduleId;

    @ManyToOne // 하나의 강의는 여러개의 스케줄을 가질 수 있음
    @JoinColumn(name = "lectureId")
    private LectureEntity lecture;

    @ManyToOne // 한 강연자는 여러개의 스케쥴을 가질 수 있음
    @JoinColumn(name = "teacherId")
    private TeacherEntity teacher;

    private LocalDate date;

    public ScheduleEntity(Long scheduleId) {
        this.scheduleId = scheduleId;
    }

    public ScheduleEntity() {
    }
}
