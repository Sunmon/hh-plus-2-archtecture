package com.hhplus.lecture.service;

import com.hhplus.lecture.domain.User;
import com.hhplus.lecture.repository.UserRepository;
import com.hhplus.lecture.repository.UserRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;

public class UserService {
    final UserRepository userRepository;

    @Autowired
    public UserService(UserRepositoryImpl userRepository) {
        this.userRepository = userRepository;
    }

    User getUser(Long userId) {
        return userRepository.findById(userId);
    }
}
