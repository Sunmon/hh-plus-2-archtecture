package com.hhplus.lecture.domain;

import com.hhplus.lecture.entity.LectureEnrollmentEntity;

import java.time.LocalDateTime;

public record LectureEnrollment (Lecture lecture, User user, LocalDateTime createdDate){


    public LectureEnrollment {
    }

    //    TODO : LectureEnrollmentEntity를 이용하여 LectureEnrollment를 구현
    public LectureEnrollment(LectureEnrollmentEntity enrollmentEntity) {
        this(null, null, null);
    }
}
