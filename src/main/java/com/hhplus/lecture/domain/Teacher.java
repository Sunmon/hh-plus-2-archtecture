package com.hhplus.lecture.domain;

import com.hhplus.lecture.entity.TeacherEntity;

public record Teacher(Long id, String name) {
    public Teacher(TeacherEntity teacherEntity) {
        this(teacherEntity.getTeacherId(), teacherEntity.getTeacherName());
    }

    // Teacher 변환을 위한 보조 메서드
    static Teacher convertToTeacher(TeacherEntity teacherEntity) {
        if (teacherEntity == null) {
            return null;  // TeacherEntity가 null이면 null 반환
        }
        return new Teacher(teacherEntity);
    }
}
