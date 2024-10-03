package com.hhplus.lecture.controller;

import com.hhplus.lecture.domain.Enrollments;
import com.hhplus.lecture.domain.Schedule;
import com.hhplus.lecture.dto.EnrollmentResponseDTO;
import com.hhplus.lecture.service.EnrollmentService;
import com.hhplus.lecture.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {

    private final ScheduleService scheduleService;
    private final EnrollmentService enrollmentService;

    @Autowired
    public ScheduleController(ScheduleService scheduleService, EnrollmentService enrollmentService) {
        this.scheduleService = scheduleService;
        this.enrollmentService = enrollmentService;
    }

    // 날짜별 스케쥴을 조회한다.
    @GetMapping    // 스케줄 조회
    public Map<LocalDate, List<Schedule>> getAllSchedule() {
        return getScheduleWithCount();
    }

    private Map<LocalDate, List<Schedule>> getScheduleWithCount() {
        List<Schedule> schedules = scheduleService.getAllSchedules();
        return schedules.stream().map(schedule ->
                schedule.withRemainCount(Enrollments.MAX_ENROLLMENT - enrollmentService.getCountOfEnrollments(schedule.id()))
        ).collect(Collectors.groupingBy(Schedule::date));
    }
    
    //  수강신청 후 결과를 리턴한다.
    @PostMapping("{id}")
    public EnrollmentResponseDTO bookSchedule(@PathVariable Long id, @RequestBody Long userId) {
        return new EnrollmentResponseDTO(enrollmentService.enrollLecture(id, userId));
    }


}
