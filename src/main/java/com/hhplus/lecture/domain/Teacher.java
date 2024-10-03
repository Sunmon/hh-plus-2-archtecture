package com.hhplus.lecture.domain;

import com.hhplus.lecture.entity.TeacherEntity;

public record Teacher(Long id, String name) {
    public Teacher(TeacherEntity teacherEntity) {
        this(teacherEntity.getId(), teacherEntity.getName());
    }

    // Teacher 변환을 위한 보조 메서드
    static Teacher fromEntity(TeacherEntity teacherEntity) {
        if (teacherEntity == null) {
            return null;  // TeacherEntity가 null이면 null 반환
        }
        return new Teacher(teacherEntity);
    }

    static TeacherEntity toEntity(Teacher teacher) {
        if (teacher == null) {
            return null;  // Teacher가 null이면 null 반환
        }
        return new TeacherEntity(teacher.id(), teacher.name());
    }

    public TeacherEntity toEntity() {
        return new TeacherEntity(this.id(), this.name());
    }
}
