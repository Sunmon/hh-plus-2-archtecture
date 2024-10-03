package com.hhplus.lecture.repository;

import com.hhplus.lecture.entity.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherJpaRepository extends JpaRepository<TeacherEntity, Long> {
}
