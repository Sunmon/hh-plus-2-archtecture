package com.hhplus.lecture.domain;

import com.hhplus.lecture.entity.LectureEntity;

public record Lecture(Long id, String name, Teacher teacher) {

    public Lecture(LectureEntity lectureEntity) {
        // repository에서 매번 조회해오는게 맞아?
        this(lectureEntity.getLectureId(), lectureEntity.getLectureName(), Teacher.convertToTeacher(lectureEntity.getTeacher()));
    }

    static Lecture convertToLecture(LectureEntity lectureEntity) {
        if (lectureEntity == null) {
            return null;
        }
        return new Lecture(lectureEntity);
    }
}
