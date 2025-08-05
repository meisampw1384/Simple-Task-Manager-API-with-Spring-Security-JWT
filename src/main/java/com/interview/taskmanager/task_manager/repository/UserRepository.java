package com.interview.taskmanager.task_manager.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.interview.taskmanager.task_manager.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
