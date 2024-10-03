package com.hhplus.lecture.domain;

import com.hhplus.lecture.entity.UserEntity;

public record User(Long userId, String userName) {

    public User(UserEntity userEntity) {
        this(userEntity.getUserId(), userEntity.getUserName());
    }

    static User convertToUser(UserEntity userEntity) {
        if (userEntity == null) {
            return null;
        }
        return new User(userEntity);
    }

}
