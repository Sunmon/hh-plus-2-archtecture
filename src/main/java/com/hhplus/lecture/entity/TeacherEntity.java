package com.hhplus.lecture.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name="teacher")
public class TeacherEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long teacherId;
    private String teacherName;

    public TeacherEntity() {
    }
}
