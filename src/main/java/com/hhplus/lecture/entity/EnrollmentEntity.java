package com.hhplus.lecture.entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

/**
 * 수강 신청 내역 Entity
 */
@Getter
@Entity
@Table(name = "enrollments")
public class EnrollmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "enrollment_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "schedule_id")
    private ScheduleEntity schedule;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    // Date는 mutable -> thread-safe (X)
    // private Date enrollmentDate;
    @CreatedDate
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime createDate;

    public EnrollmentEntity() {
    }

    public EnrollmentEntity(Long id, ScheduleEntity scheduleEntity, UserEntity user, LocalDateTime createDate) {
        this.id = id;
        this.schedule = scheduleEntity;
        this.user = user;
        this.createDate = createDate;
    }

}
