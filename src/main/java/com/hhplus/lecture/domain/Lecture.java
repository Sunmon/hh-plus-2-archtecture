package com.hhplus.lecture.domain;

import com.hhplus.lecture.entity.LectureEntity;
import com.hhplus.lecture.entity.TeacherEntity;

public record Lecture(Long id, String name, Teacher teacher) {

    public Lecture(LectureEntity lectureEntity) {
        // repository에서 매번 조회해오는게 맞아?
        this(lectureEntity.getLectureId(), lectureEntity.getLectureName(), convertToTeacher(lectureEntity.getTeacher()));
    }

    // Teacher 변환을 위한 보조 메서드
    private static Teacher convertToTeacher(TeacherEntity teacherEntity) {
        if (teacherEntity == null) {
            return null;  // TeacherEntity가 null이면 null 반환
        }
        return new Teacher(teacherEntity);
    }
}
