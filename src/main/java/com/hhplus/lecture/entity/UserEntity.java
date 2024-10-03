package com.hhplus.lecture.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Getter
@Table(name = "users")
public class UserEntity {
    @Id
    @Column(name = "user_id")
    Long id;
    String name;

    public UserEntity(Long userId, String userName) {
        this.id = userId;
        this.name = userName;
    }

    public UserEntity() {
    }
}
