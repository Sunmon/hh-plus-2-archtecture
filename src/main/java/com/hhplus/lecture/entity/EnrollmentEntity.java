package com.hhplus.lecture.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

/**
 * 수강 신청 내역 Entity
 */
@Getter
@Entity
@ToString
public class EnrollmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long enrollmentId;

    @Column(nullable = false)
    @JoinColumn(name = "scheduleId")
    private ScheduleEntity schedule;

    @Column(nullable = false)
    @JoinColumn(name = "userId")
    private UserEntity user;

    // Date는 mutable -> thread-safe (X)
    // private Date enrollmentDate;
    @CreatedDate
    private LocalDateTime createDate;

    public EnrollmentEntity() {
    }

    public EnrollmentEntity(Long id, ScheduleEntity scheduleEntity, UserEntity user, LocalDateTime createDate) {
        this.enrollmentId = id;
        this.schedule = scheduleEntity;
        this.user = user;
        this.createDate = createDate;
    }

}
