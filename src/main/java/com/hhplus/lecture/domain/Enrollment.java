package com.hhplus.lecture.domain;

import com.hhplus.lecture.entity.EnrollmentEntity;

import java.time.LocalDateTime;

import static com.hhplus.lecture.domain.User.fromEntity;

public record Enrollment(Long id, Schedule schedule, User user, LocalDateTime createdDate) {
    public Enrollment(EnrollmentEntity enrollmentEntity) {
        this(enrollmentEntity.getId(), Schedule.fromEntity(enrollmentEntity.getSchedule()), fromEntity(enrollmentEntity.getUser()), enrollmentEntity.getCreateDate());
    }

    public EnrollmentEntity toEntity(Enrollment enrollment) {
//        if (enrollment.createdDate == null) {
        return new EnrollmentEntity(enrollment.id(), enrollment.schedule().toEntity(), enrollment.user().toEntity());
//        }
//        return new EnrollmentEntity(enrollment.id(), enrollment.schedule().toEntity(), enrollment.user().toEntity(), enrollment.createdDate());
    }


    public EnrollmentEntity toEntity() {
//        if (this.createdDate == null) {
        return new EnrollmentEntity(id, Schedule.toEntity(schedule), User.toEntity(user));
//        }
//        return new EnrollmentEntity(id, Schedule.toEntity(schedule), User.toEntity(user), createdDate);
    }
}
