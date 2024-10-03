package com.hhplus.lecture.repository;

import com.hhplus.lecture.domain.Teacher;

public interface TeacherRepository {
    //    List<TeacherEntity> findById(Long lectureId);

    //    List<TeacherEntity> findByUserId(Long id);
    Teacher findById(Long teacherId);
}
