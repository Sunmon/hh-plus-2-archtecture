package com.hhplus.lecture.domain;

import com.hhplus.lecture.entity.TeacherEntity;

public record Teacher(Long id, String name) {
    public Teacher(TeacherEntity teacherEntity) {
        this(teacherEntity.getTeacherId(), teacherEntity.getTeacherName());
    }
}
