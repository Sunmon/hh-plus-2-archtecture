package com.hhplus.lecture.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Getter
@Entity
@Table(name = "lectures")
public class LectureEntity {
    @Id
    @Column(name = "lecture_id")
    private Long id;
    private String name;

    public LectureEntity() {
    }

    public LectureEntity(Long lectureId, String name) {
        this.id = lectureId;
        this.name = name;
    }
}
