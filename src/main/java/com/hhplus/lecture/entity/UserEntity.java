package com.hhplus.lecture.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
@Getter
public class UserEntity {
    @Id
    Long userId;
    String userName;

    public UserEntity(Long userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    public UserEntity() {
    }
}
