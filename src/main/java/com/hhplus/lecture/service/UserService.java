package com.hhplus.lecture.service;

import com.hhplus.lecture.common.UserException;
import com.hhplus.lecture.domain.User;
import com.hhplus.lecture.repository.UserRepository;
import com.hhplus.lecture.repository.UserRepositoryImpl;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    final UserRepository userRepository;

    @Autowired
    public UserService(UserRepositoryImpl userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    User getUser(Long userId) throws UserException {
        return userRepository.findById(userId);
    }
}
