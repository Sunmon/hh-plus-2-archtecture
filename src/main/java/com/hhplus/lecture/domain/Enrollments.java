package com.hhplus.lecture.domain;

import java.util.List;

public class Enrollments {

    static final int MAX_ENROLLMENT = 30;

    List<Enrollment> enrollmentList;

    public Enrollments(List<Enrollment> enrollmentList) {
        this.enrollmentList = enrollmentList;
    }

    public boolean isLectureFull() {
        return this.enrollmentList.size() >= MAX_ENROLLMENT;
    }

    public static boolean isLectureFull(Enrollments enrollments) {
        return enrollments.enrollmentList.size() >= MAX_ENROLLMENT;
    }

    public Enrollment getByUser(Long userId) {
        return this.enrollmentList.stream()
                .filter(enrollment -> enrollment.user().id().equals(userId))
                .findAny()
                .orElse(null);
    }

    public int size() {
        return this.enrollmentList.size();
    }
}
