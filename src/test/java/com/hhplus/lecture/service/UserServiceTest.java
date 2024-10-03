package com.hhplus.lecture.service;

import com.hhplus.lecture.repository.UserJpaRepository;
import com.hhplus.lecture.repository.UserRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;

public class UserServiceTest {
    @Mock
    UserJpaRepository userJpaRepository;

    @InjectMocks
    UserRepositoryImpl userRepository;

    UserService userService;

    @BeforeEach
    void setUp() {
        userService = new UserService(userRepository);
    }

}
