package com.hhplus.lecture.service;

import com.hhplus.lecture.common.EnrollmentException;
import com.hhplus.lecture.common.ErrorCode;
import com.hhplus.lecture.domain.Enrollment;
import com.hhplus.lecture.domain.Enrollments;
import com.hhplus.lecture.domain.Schedule;
import com.hhplus.lecture.domain.User;
import com.hhplus.lecture.repository.EnrollmentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnrollmentService {

    //    EnrollmentJpaRepository enrollmentJpaRepository;
    final EnrollmentRepository enrollmentRepository;
    final ScheduleService scheduleService;

    final UserService userService;

    @Autowired
    public EnrollmentService(EnrollmentRepository enrollmentRepository, ScheduleService scheduleService, UserService userService) {
        this.enrollmentRepository = enrollmentRepository;
        this.scheduleService = scheduleService;
        this.userService = userService;
    }

    @Transactional
    public Enrollment getEnrollment(Long enrollmentId) {
        return enrollmentRepository.findById(enrollmentId);
    }

    @Transactional
    private Enrollment getEnrollment(Long scheduleId, Long userId) {
        Enrollment enrollment = getEnrollmentsBySchedule(scheduleId).getByUser(userId);
        if (enrollment == null) {
            throw new EnrollmentException(ErrorCode.ENROLLMENT_NOT_FOUND, null, scheduleId, userId);
        }

        return enrollment;
    }

    @Transactional
    public int getCountOfEnrollments(Long scheduleId) {
        return getEnrollmentsBySchedule(scheduleId).size();
    }

    @Transactional
    public Enrollments getEnrollmentsBySchedule(Long scheduleId) {
        return enrollmentRepository.findByScheduleId(scheduleId);
    }


    @Transactional
    public Enrollments getEnrollmentsByUser(Long userId) {
        return enrollmentRepository.findByUserId(userId);
    }


    @Transactional
    private boolean isUserEnrolled(Long scheduleId, Long userId) {
        return getEnrollmentsBySchedule(scheduleId).getByUser(userId) != null;
    }

    @Transactional
    public Enrollment enrollLecture(Long scheduleId, Long userId) {
//        try {

        Schedule schedule = scheduleService.getSchedule(scheduleId);
        User user = userService.getUser(userId);

        // 이미 등록한 강의
        if (isUserEnrolled(scheduleId, userId)) {
            System.out.println("이미 등록한 강의");
            throw new EnrollmentException(ErrorCode.ENROLLMENT_ALREADY_EXISTS, null, scheduleId, userId);
        }
        // 강의 인원 초과
        if (Enrollments.isLectureFull(getEnrollmentsBySchedule(scheduleId))) {
            throw new EnrollmentException(ErrorCode.ENROLMENT_LIMIT_EXCEEDED, null, scheduleId, userId);
        }

        // 강의 등록
        Enrollment enrollment = new Enrollment(null, schedule, user, null);
        return enrollmentRepository.insert(enrollment);


//        } catch (EnrollmentException e) {
//            TODO 다른 예외 처리... cause 필요?
//            System.out.println(e);
//            throw new EnrollmentException(ErrorCode.ENROLLMENT_FAILED, null, scheduleId, userId);
//        }
    }
}
