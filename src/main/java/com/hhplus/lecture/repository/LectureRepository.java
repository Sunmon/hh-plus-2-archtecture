package com.hhplus.lecture.repository;

import com.hhplus.lecture.domain.Lecture;
import org.springframework.stereotype.Repository;

@Repository
public interface LectureRepository {
    Lecture findById(Long lectureId);

}
