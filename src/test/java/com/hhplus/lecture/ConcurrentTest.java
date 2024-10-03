package com.hhplus.lecture;

import com.hhplus.lecture.domain.Enrollments;
import com.hhplus.lecture.repository.EnrollmentRepository;
import com.hhplus.lecture.service.EnrollmentService;
import jakarta.transaction.Transactional;
import jdk.jfr.Description;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ConcurrentTest {

    @Autowired
    private EnrollmentService enrollmentService;  // EnrollmentService 주입

    @Autowired
    private EnrollmentRepository enrollmentRepository;  // EnrollmentRepository 주입

    @Description("동시에 서로 다른 40명의 사용자가 동일한 스케줄에 수강신청하면 30명만 성공해야 한다.")
    @Test
    @Transactional
    void testConcurrentEnrollment() throws InterruptedException, ExecutionException {
        Long scheduleId = 1L;
        Long userId = 1L;

        // given
        ExecutorService executorService = Executors.newFixedThreadPool(40);
        List<Future<Void>> futures = new ArrayList<>();


        for (int i = 0; i < 40; i++) {
            Long currentUserId = userId + i;  // 각 스레드마다 다른 userId를 사용하도록 설정

            Callable<Void> task = () -> {
                try {
                    enrollmentService.enrollLecture(scheduleId, currentUserId);
                } catch (Exception e) {
                    System.out.println("30명 초과하여 exception 발생");
//                    e.printStackTrace();
                }

                return null;
            };
            futures.add(executorService.submit(task));  // 스레드 실행
        }


        for (Future<Void> future : futures) {
            future.get();
        }

        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES);

        Enrollments enrollments = enrollmentService.getEnrollmentsBySchedule(scheduleId);

        // then
        // 30개만 있어야 함.
        assertThat(enrollments.size()).isEqualTo(30);
    }


    @Description("동일한 사용자가 동일한 특강에 대해 한번씩만 신청 가능해야 한다.")
    @Test
    @Transactional
    void testConcurrentEnrollmentOnlyOnce() throws InterruptedException, ExecutionException {
        Long scheduleId = 1L;
        Long userId = 1L;

        // given
        ExecutorService executorService = Executors.newFixedThreadPool(30);
        List<Future<Void>> futures = new ArrayList<>();


        for (int i = 0; i < 5; i++) {
            Long currentUserId = userId;  // 같은 사용자가 여러번 신청

            Callable<Void> task = () -> {
                try {
                    enrollmentService.enrollLecture(scheduleId, currentUserId);
                } catch (Exception e) {
                    System.out.println("신청 1번 초과하여 exception 발생");
//                    e.printStackTrace();
                }

                return null;
            };
            futures.add(executorService.submit(task));  // 스레드 실행
        }


        for (Future<Void> future : futures) {
            future.get();
        }

        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES);

        // then
        Enrollments enrollments = enrollmentService.getEnrollmentsBySchedule(scheduleId);

        // 같은 사용자는 한번씩만 신청 가능해야 함.
        assertThat(enrollments.size()).isEqualTo(1);
        assertThat(enrollments.getEnrollmentList().stream().map(enrollment -> enrollment.user().id())).doesNotHaveDuplicates();
    }


}
