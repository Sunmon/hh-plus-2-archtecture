package com.hhplus.lecture.repository;

import com.hhplus.lecture.common.ErrorCode;
import com.hhplus.lecture.common.UserException;
import com.hhplus.lecture.domain.User;
import com.hhplus.lecture.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private final UserJpaRepository userJpaRepository;

    @Autowired
    public UserRepositoryImpl(UserJpaRepository userJpaRepository) {
        this.userJpaRepository = userJpaRepository;
    }

    @Override
    public User findById(Long userId) throws UserException {
        UserEntity userEntity = userJpaRepository.findById(userId).orElseThrow(() -> new UserException(ErrorCode.USER_NOT_FOUND, userId));
        return new User(userEntity);
    }
}
