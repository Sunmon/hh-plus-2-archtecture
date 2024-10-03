package com.hhplus.lecture.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Getter
@Entity
@Table(name = "lecture")
public class LectureEntity {
    @Id
    private Long lectureId;
    private String lectureName;

    public LectureEntity() {
    }

    public LectureEntity(Long lectureId, String lectureName) {
        this.lectureId = lectureId;
        this.lectureName = lectureName;
    }
}
