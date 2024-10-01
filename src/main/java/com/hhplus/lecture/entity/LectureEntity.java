package com.hhplus.lecture.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;

@Getter
@Entity
@Table(name="lecture")
public class LectureEntity {
    @Id
    private Long lectureId;
    private String lectureName;
    @ManyToOne // 강의 여러개가 동시에 한 선생님을 참조할 수 있음
    private TeacherEntity teacher; // REVIEW - 엔티티에서 teacherId필드만 가지고 있기 vs teacherEntity 자체 가지고 있기

    public LectureEntity() {
    }

    public LectureEntity(Long lectureId, String lectureName, TeacherEntity teacher) {
        this.lectureId = lectureId;
        this.lectureName = lectureName;
        this.teacher = teacher;
    }
}
