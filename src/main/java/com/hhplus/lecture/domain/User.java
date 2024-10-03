package com.hhplus.lecture.domain;

import com.hhplus.lecture.entity.UserEntity;

public record User(Long id, String userName) {

    public User(UserEntity userEntity) {
        this(userEntity.getUserId(), userEntity.getUserName());
    }

    static User fromEntity(UserEntity userEntity) {
        if (userEntity == null) {
            return null;
        }
        return new User(userEntity);
    }

    static UserEntity toEntity(User user) {
        return new UserEntity(user.id(), user.userName());
    }

    UserEntity toEntity() {
        return toEntity(this);
    }

}
