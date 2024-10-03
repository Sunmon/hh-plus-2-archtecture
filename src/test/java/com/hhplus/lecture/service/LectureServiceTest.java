package com.hhplus.lecture.service;

import com.hhplus.lecture.domain.Lecture;
import com.hhplus.lecture.entity.LectureEntity;
import com.hhplus.lecture.repository.LectureJpaRepository;
import com.hhplus.lecture.repository.LectureRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)

public class LectureServiceTest {

    @Mock
    LectureJpaRepository lectureJpaRepository;
    @InjectMocks
    LectureRepositoryImpl lectureRepository;

    LectureService lectureService;

    @BeforeEach
    void setUp() {
//        MockitoAnnotations.openMocks(this);
        lectureService = new LectureService(lectureRepository);
    }

    @DisplayName("강의 ID로 강의 정보를 조회한다")
    @Test
    void getLectureById() {
        // given
        Long lectureId = 1L;
        LectureEntity lectureEntity = new LectureEntity(lectureId, "운영체제");
        when(lectureJpaRepository.findById(lectureId)).thenReturn(Optional.of(lectureEntity));
        // when
        Lecture lecture = lectureService.getLectureDetail(lectureId);
        // then
        assertThat(lecture.id()).isEqualTo(lectureId);
        assertThat(lecture.name()).isEqualTo("운영체제");
    }
}
