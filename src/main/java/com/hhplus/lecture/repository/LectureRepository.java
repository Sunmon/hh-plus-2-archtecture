package com.hhplus.lecture.repository;

import com.hhplus.lecture.entity.LectureEntity;

public interface LectureRepository {
    LectureEntity findById(Long lectureId);
}
