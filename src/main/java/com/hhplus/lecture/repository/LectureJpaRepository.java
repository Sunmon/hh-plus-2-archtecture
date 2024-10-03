package com.hhplus.lecture.repository;

import com.hhplus.lecture.entity.LectureEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LectureJpaRepository extends JpaRepository<LectureEntity, Long> {
//    Optional<LectureEntity> findById(Long lectureId);
}
