package com.hhplus.lecture.service;

import com.hhplus.lecture.domain.Lecture;
import com.hhplus.lecture.domain.LectureEnrollment;
import com.hhplus.lecture.entity.LectureEnrollmentEntity;
import com.hhplus.lecture.entity.LectureEntity;
import com.hhplus.lecture.entity.TeacherEntity;
import com.hhplus.lecture.entity.UserEntity;
import com.hhplus.lecture.repository.LectureEnrollmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LectureEnrollmentServiceTest {

    private LectureEnrollmentService lectureEnrollmentService;
    private LectureEnrollmentRepository lectureEnrollmentRepository;

    @BeforeEach
    void setUp() {
        lectureEnrollmentRepository = new LectureEnrollmentRepository() {
            List<LectureEnrollmentEntity> db = Arrays.asList(
                    new LectureEnrollmentEntity(new LectureEntity(1L, "운영체제", new TeacherEntity()), new UserEntity(123L, "김강배")),
                    new LectureEnrollmentEntity(new LectureEntity(2L, "정보통신", new TeacherEntity()), new UserEntity(123L, "구준표")),
                    new LectureEnrollmentEntity(new LectureEntity(1L, "운영체제", new TeacherEntity()), new UserEntity(321L, "도민준")),
                    new LectureEnrollmentEntity(new LectureEntity(3L, "데이터베이스", new TeacherEntity()), new UserEntity(321L, "도민준"))
            );

            @Override
            public List<LectureEnrollmentEntity> findByUserId(Long userId) {
                return db.stream().filter(enrollment -> enrollment.getUser().userId().equals(userId)).toList();
            }

            @Override
            public List<LectureEnrollmentEntity> findById(Long lectureId) {
                return db.stream().filter(enrollment -> enrollment.getLecture().getLectureId().equals(lectureId)).toList();
            }
        };
        lectureEnrollmentService = new LectureEnrollmentService(lectureEnrollmentRepository);
    }

    @DisplayName("유저의 ID로 신청한 특강 목록을 조회할 수 있어야 한다.")
    @Test
    void testGetEnrolledLectures() {
        // given
        Long userId = 123L;
        // when
        List<LectureEnrollment> enrollments = lectureEnrollmentService.getLectureEnrollments(userId);
        System.out.println(enrollments);
        // then
        assertThat(enrollments).allMatch(enrollment -> enrollment.lecture().id().equals(userId));
    }
}
