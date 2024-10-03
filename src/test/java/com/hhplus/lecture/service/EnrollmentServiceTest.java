package com.hhplus.lecture.service;

import com.hhplus.lecture.domain.Enrollment;
import com.hhplus.lecture.domain.Enrollments;
import com.hhplus.lecture.domain.Schedule;
import com.hhplus.lecture.domain.User;
import com.hhplus.lecture.entity.EnrollmentEntity;
import com.hhplus.lecture.entity.ScheduleEntity;
import com.hhplus.lecture.entity.UserEntity;
import com.hhplus.lecture.repository.EnrollmentRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EnrollmentServiceTest {


    //    @Mock
//    private ScheduleRepository scheduleRepository;
    @Mock
    private ScheduleService scheduleService;

    //    @Mock
//    private UserRepository userRepository;
    @Mock
    private UserService userService;

    //    @InjectMocks
    @Mock
    private EnrollmentRepositoryImpl enrollmentRepository;

    @InjectMocks
    private EnrollmentService enrollmentService;

    @BeforeEach
    void setUp() {


//        enrollmentJpaRepository = new EnrollmentJpaRepository() {
//            List<EnrollmentEntity> db = Arrays.asList(
//                    new EnrollmentEntity(new LectureEntity(1L, "운영체제", new TeacherEntity()), new UserEntity(123L, "김강배")),
//                    new EnrollmentEntity(new LectureEntity(2L, "정보통신", new TeacherEntity()), new UserEntity(123L, "구준표")),
//                    new EnrollmentEntity(new LectureEntity(1L, "운영체제", new TeacherEntity()), new UserEntity(321L, "도민준")),
//                    new EnrollmentEntity(new LectureEntity(3L, "데이터베이스", new TeacherEntity()), new UserEntity(321L, "도민준"))
//            );
//
//            @Override
//            public List<EnrollmentEntity> findByUserId(Long id) {
//                return db.stream().filter(enrollment -> enrollment.getUser().id().equals(id)).toList();
//            }
//
//            @Override
//            public Optional<EnrollmentEntity> findById(Long lectureId) {
//                return db.stream().filter(enrollment -> enrollment.getLecture().getLectureId().equals(lectureId)).toList();
//            }
//        };
//
//        enrollmentService = new EnrollmentService(enrollmentRepository, scheduleService, userService);
    }

    @DisplayName("특정 특강을 조회한다.")
    @Test
    void testGetEnrollmentDetail() {
        // given
        Long enrollmentId = 1L;
        EnrollmentEntity enrollmentEntity = new EnrollmentEntity(enrollmentId, new ScheduleEntity(), new UserEntity());
        when(enrollmentRepository.findById(enrollmentId)).thenReturn(new Enrollment(enrollmentEntity));
        // when
        Enrollment enrollment = enrollmentService.getEnrollment(enrollmentId);
        // then
        assertThat(enrollment.id()).isEqualTo(enrollmentId);
    }


    @DisplayName("특정 강의를 신청한 목록을 가져온다.")
    @Test
    void testGetEnrollments() {
        // given
        Long enrollmentId = 1L;
        Long scheduleId = 123L;
        EnrollmentEntity enrollmentEntity1 = new EnrollmentEntity(1L, new ScheduleEntity(scheduleId), new UserEntity());
        EnrollmentEntity enrollmentEntity2 = new EnrollmentEntity(2L, new ScheduleEntity(scheduleId), new UserEntity());
        // when
        when(enrollmentRepository.findByScheduleId(scheduleId)).thenReturn(new Enrollments(List.of(new Enrollment(enrollmentEntity1), new Enrollment(enrollmentEntity2))));
        Enrollments enrollments = enrollmentService.getEnrollmentsBySchedule(scheduleId);
        // then
        assertThat(enrollments.size()).isEqualTo(2);
    }


    @Test
    void test() {
        // given
        Long scheduleId = 123L;
        // when
        when(scheduleService.getSchedule(scheduleId)).thenReturn(new Schedule(new ScheduleEntity(scheduleId)));
//        List<Enrollment> enrollments = enrollmentService.getLectureEnrollments(userId);
        Schedule result = scheduleService.getSchedule(scheduleId);
        // then
        assertThat(result.id()).isEqualTo(scheduleId);
    }

    @DisplayName("특강을 신청하고, 성공한다면 특강의 정보를 반환한다.")
    @Test
    void testEnrollLecture() {
        // given
        Long enrollmentId = null;
        Long userId = 123L;
        Long scheduleId = 123L;

        // REVIEW - 테스트 조건이 너무 강결합 된 것 같다
        EnrollmentEntity enrollmentEntity = new EnrollmentEntity(enrollmentId, new ScheduleEntity(scheduleId), new UserEntity(userId, "유저1"));
        Enrollment enrollment = new Enrollment(enrollmentEntity);

        when(userService.getUser(userId)).thenReturn(new User(new UserEntity(userId, "유저1")));
        when(scheduleService.getSchedule(scheduleId)).thenReturn(new Schedule(new ScheduleEntity(scheduleId)));
        when(enrollmentRepository.findByScheduleId(scheduleId)).thenReturn(new Enrollments(List.of()));
        when(enrollmentRepository.insert(enrollment)).thenReturn(enrollment);

        // when
        Enrollment result = enrollmentService.enrollLecture(scheduleId, userId);

        // then
        assertThat(result.schedule().id()).isEqualTo(scheduleId);
    }

//    @DisplayName("특강을 신청하고, 실패한다면 실패 정보를 던진다.")
//    @Test
//    void testEnrollLectureWithFailure() {
//        // given
//        Long enrollmentId = 3L;
//        Long userId = 123L;
//        // when
//        // when, then
//        assertThatThrownBy(() -> enrollmentService.enrollLecture(enrollmentId, userId))
//                .isInstanceOf(IllegalArgumentException.class)
//                .hasMessage("이미 신청한 특강입니다.");
//
//        assertThatThrownBy(() -> enrollmentService.enrollLecture(enrollmentId, userId))
//                .isInstanceOf(IllegalArgumentException.class)
//                .hasMessage("해당하는 특강이 없습니다.");
//
//        assertThatThrownBy(() -> enrollmentService.enrollLecture(enrollmentId, userId))
//                .isInstanceOf(IllegalArgumentException.class)
//                .hasMessage("수강할 수 있는 인원을 초과하였습니다.");
//    }
}
