package com.hhplus.lecture.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "teachers")
public class TeacherEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teacher_id")
    private Long id;
    private String name;

    public TeacherEntity() {
    }

    public TeacherEntity(Long teacherId, String teacherName) {
        this.id = teacherId;
        this.name = teacherName;
    }
}
