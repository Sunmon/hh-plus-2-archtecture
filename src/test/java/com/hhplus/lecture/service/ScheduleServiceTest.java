package com.hhplus.lecture.service;

import com.hhplus.lecture.domain.Schedule;
import com.hhplus.lecture.entity.LectureEntity;
import com.hhplus.lecture.entity.ScheduleEntity;
import com.hhplus.lecture.repository.ScheduleRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class ScheduleServiceTest {

    //    @Mock
//    ScheduleJpaRepository scheduleJpaRepository;
    @Mock
    ScheduleRepositoryImpl scheduleRepository;

    ScheduleService scheduleService;

    @BeforeEach
    void setUp() {
        scheduleService = new ScheduleService(scheduleRepository);
    }

    @DisplayName("스케줄 ID로 스케줄 정보를 조회한다")
    @Test
    void testGetScheduleById() {
        // given
        Long scheduleId = 1L;
        ScheduleEntity scheduleEntity = new ScheduleEntity(scheduleId);
        when(scheduleRepository.findById(scheduleId)).thenReturn(new Schedule(scheduleEntity));
        // when
        Schedule schedule = scheduleService.getSchedule(scheduleId);
        // then
        assertThat(schedule.id()).isEqualTo(scheduleId);
    }


    @DisplayName("모든 스케줄 정보를 날짜별로 그룹핑하여 조회한다")
    @Test
    void testGetSchedulesByIdGroupInDate() {
        // given
//        Long scheduleId = 1L;
//        ScheduleEntity scheduleEntity = new ScheduleEntity(scheduleId);
//        Map<LocalDate , List<Schedule>> mockSchedules = Map.of(
//                LocalDate.of(2024, 10, 1), List.of(new Schedule(new ScheduleEntity(1L))),
//                LocalDate.of(2024, 10, 2), List.of(new Schedule(new ScheduleEntity(2L)))
//                LocalDate.of(2024, 10, 3), List.of(
//                        new Schedule(new ScheduleEntity(2L)),
//                        new Schedule(new ScheduleEntity(2L)),
//                        new Schedule(new ScheduleEntity(3L)),
//                        new Schedule(new ScheduleEntity(4L)),
//                        new Schedule(new ScheduleEntity(6L))
//        ));
        List<ScheduleEntity> allSchedules = List.of(
                new ScheduleEntity(1L, new LectureEntity(1L, null), null, LocalDate.of(2024, 10, 1)),
                new ScheduleEntity(2L, new LectureEntity(1L, null), null, LocalDate.of(2024, 10, 1)),
                new ScheduleEntity(3L, new LectureEntity(2L, null), null, LocalDate.of(2024, 10, 2)),
                new ScheduleEntity(4L, new LectureEntity(3L, null), null, LocalDate.of(2024, 10, 2)),
                new ScheduleEntity(5L, new LectureEntity(3L, null), null, LocalDate.of(2024, 10, 3)),
                new ScheduleEntity(6L, new LectureEntity(4L, null), null, LocalDate.of(2024, 10, 3)),
                new ScheduleEntity(7L, new LectureEntity(5L, null), null, LocalDate.of(2024, 10, 5))
        );

        Map scheduleMap = allSchedules.stream().collect(Collectors.groupingBy(ScheduleEntity::getDate));

//        when(scheduleRepository.findByLectureIdGroupInDate()).thenReturn(mockSchedules);
//        when(scheduleRepository.findAll()).thenReturn(allSchedules.stream().map(Schedule::new).toList());
        when(scheduleRepository.findAllGroupInDate()).thenReturn(scheduleMap);

        // when
        Map<LocalDate, List<Schedule>> schedules = scheduleService.getSchedulesGroupByDate();
        // then
        assertThat(schedules.get(LocalDate.of(2024, 10, 1)).size()).isEqualTo(2);
    }


}
