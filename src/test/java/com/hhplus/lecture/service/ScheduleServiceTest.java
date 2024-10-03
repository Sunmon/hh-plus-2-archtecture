package com.hhplus.lecture.service;

import com.hhplus.lecture.domain.Schedule;
import com.hhplus.lecture.entity.ScheduleEntity;
import com.hhplus.lecture.repository.ScheduleJpaRepository;
import com.hhplus.lecture.repository.ScheduleRepositoryImpl;
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
public class ScheduleServiceTest {

    @Mock
    ScheduleJpaRepository scheduleJpaRepository;
    @InjectMocks
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
        when(scheduleJpaRepository.findById(scheduleId)).thenReturn(Optional.of(scheduleEntity));
        // when
        Schedule schedule = scheduleService.getSchedule(scheduleId);
        // then
        assertThat(schedule.id()).isEqualTo(scheduleId);
    }

}
