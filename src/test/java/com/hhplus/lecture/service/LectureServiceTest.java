package com.hhplus.lecture.service;

import com.hhplus.lecture.domain.Lecture;
import com.hhplus.lecture.entity.LectureEntity;
import com.hhplus.lecture.repository.LectureRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;;

public class LectureServiceTest {

    LectureService lectureService;
    LectureRepository lectureRepository;

    @BeforeEach
    void setUp() {
        lectureRepository = new LectureRepository(){
            @Override
            public LectureEntity findById(Long lectureId) {
                return new LectureEntity(lectureId, "운영체제", null);
            }
        };

//        lectureRepository = lectureId -> new LectureEntity(lectureId, "운영체제", 100L);


        lectureService = new LectureService(lectureRepository);
    }

    @DisplayName("강의 ID로 강의 정보를 조회한다")
    @Test
    void getLectureById() {
        // given
        Long lectureId = 1L;
        // when
        Lecture lecture = lectureService.getLectureDetail(lectureId);
        // then
        assertThat(lecture.id()).isEqualTo(lectureId);
    }

}
