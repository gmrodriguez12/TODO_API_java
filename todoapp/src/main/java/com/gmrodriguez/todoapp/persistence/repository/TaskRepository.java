package com.gmrodriguez.todoapp.persistence.repository;

import com.gmrodriguez.todoapp.persistence.entity.Task;
import com.gmrodriguez.todoapp.persistence.entity.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface TaskRepository extends JpaRepository<Task, Long> {
    public List<Task> findAllByStatus(TaskStatus status);
    //con esto JPA sabe que debe aplicar un findAll y filtrar por status
}
