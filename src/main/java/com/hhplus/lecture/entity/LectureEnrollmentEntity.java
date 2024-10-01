package com.hhplus.lecture.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Entity
@ToString
public class LectureEnrollmentEntity {
    @Column(nullable = false)
    // REVIEW 고민 - lectureId를 가질것인가 Lecture 엔티티를 가질 것인가...
    // private Long lectureId;
    private LectureEntity lecture;

    @Column(nullable = false)
//    private Long userId;
    private UserEntity user;
    // Date는 mutable -> thread-safe (X)
    // private Date enrollmentDate;

    @CreatedDate
    private LocalDateTime createDate;

    public LectureEnrollmentEntity() {
    }

    public LectureEnrollmentEntity(LectureEntity lecture, UserEntity user) {
        this.lecture = lecture;
        this.user = user;
    }

}
