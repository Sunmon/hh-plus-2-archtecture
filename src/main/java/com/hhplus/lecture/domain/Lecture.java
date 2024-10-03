package com.hhplus.lecture.domain;

import com.hhplus.lecture.entity.LectureEntity;

public record Lecture(Long id, String name) {

    public Lecture(LectureEntity lectureEntity) {
        // repository에서 매번 조회해오는게 맞아?
        this(lectureEntity.getId(), lectureEntity.getName());
    }

    static Lecture fromEntity(LectureEntity lectureEntity) {
        if (lectureEntity == null) {
            return null;
        }
        return new Lecture(lectureEntity);
    }

    static LectureEntity toEntity(Lecture lecture) {
        if (lecture == null) {
            return null;
        }
        return new LectureEntity(lecture.id(), lecture.name());
    }

    public LectureEntity toEntity() {
        return new LectureEntity(this.id(), this.name());
    }
}
