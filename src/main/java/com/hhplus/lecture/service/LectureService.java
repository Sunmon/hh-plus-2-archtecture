package com.hhplus.lecture.service;

import com.hhplus.lecture.domain.Lecture;
import com.hhplus.lecture.repository.LectureRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class LectureService {
    final LectureRepository lectureRepository;

    @Transactional
    public Lecture getLectureDetail(Long lectureId) {
        return lectureRepository.findById(lectureId);
    }
}
