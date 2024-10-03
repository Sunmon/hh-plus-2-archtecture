package com.hhplus.lecture.repository;

import com.hhplus.lecture.common.ErrorCode;
import com.hhplus.lecture.common.LectureException;
import com.hhplus.lecture.domain.Lecture;
import com.hhplus.lecture.entity.LectureEntity;
import org.springframework.beans.factory.annotation.Autowired;

public class LectureRepositoryImpl implements LectureRepository {
    private LectureJpaRepository lectureJpaRepository;

    @Autowired
    public LectureRepositoryImpl(LectureJpaRepository lectureJpaRepository) {
        this.lectureJpaRepository = lectureJpaRepository;
    }

    @Override
    public Lecture findById(Long lectureId) throws LectureException {
        LectureEntity lectureEntity = lectureJpaRepository.findById(lectureId)
                .orElseThrow(() -> new LectureException(ErrorCode.LECTURE_NOT_FOUND, lectureId));

        return new Lecture(lectureEntity);
    }
}
