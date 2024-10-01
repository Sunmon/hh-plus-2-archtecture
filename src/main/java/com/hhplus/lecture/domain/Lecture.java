package com.hhplus.lecture.domain;

import com.hhplus.lecture.entity.LectureEntity;

public record Lecture(Long id, String name, String teacherName) {

    public Lecture(LectureEntity lectureEntity) {
        // repository에서 매번 조회해오는게 맞아?
//        this(lectureEntity.getLectureId(), lectureEntity.getLectureName(), lectureEntity.getTeacherId());
        this(lectureEntity.getLectureId(), lectureEntity.getLectureName(), "teacherName");
    }
}
