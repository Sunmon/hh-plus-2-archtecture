package com.hhplus.lecture.service;

import com.hhplus.lecture.domain.Lecture;
import com.hhplus.lecture.entity.LectureEntity;
import com.hhplus.lecture.repository.LectureRepository;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class LectureService {
    final LectureRepository lectureRepository;
    public Lecture getLectureDetail(Long lectureId) {
        LectureEntity lectureEntity = lectureRepository.findById(lectureId);
        return new Lecture(lectureEntity);
    }
}
