package com.hhplus.lecture.repository;


import com.hhplus.lecture.domain.User;

public interface UserRepository {
    User findById(Long userId);
}
