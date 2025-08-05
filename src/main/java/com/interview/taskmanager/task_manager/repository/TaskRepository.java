package com.interview.taskmanager.task_manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.interview.taskmanager.task_manager.model.Task;

public interface TaskRepository extends JpaRepository<Task,Long>{

    
} 
    

