package com.hhplus.lecture.repository;

import com.hhplus.lecture.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<UserEntity, Long> {
//    Optional<UserEntity> findById(Long userId);
}
