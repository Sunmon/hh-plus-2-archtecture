package com.hhplus.lecture.repository;

import com.hhplus.lecture.domain.Teacher;
import com.hhplus.lecture.entity.TeacherEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TeacherRepositoryImpl implements TeacherRepository {
    TeacherJpaRepository jpaRepository;

    @Autowired
    public TeacherRepositoryImpl(TeacherJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Teacher findById(Long teacherId) throws RuntimeException {
        TeacherEntity teacherEntity = jpaRepository.findById(teacherId).orElseThrow(RuntimeException::new);
        return new Teacher(teacherEntity);
    }
}
