package com.gmrodriguez.todoapp.persistence.repository;

import com.gmrodriguez.todoapp.persistence.entity.Task;
import com.gmrodriguez.todoapp.persistence.entity.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface TaskRepository extends JpaRepository<Task, Long> {
    //con esto JPA sabe que debe aplicar un findAll y filtrar por status
    public List<Task> findAllByStatus(TaskStatus status);

    @Modifying
    @Query(value = "UPDATE TASKS SET FINISHED = TRUE WHERE id = :id", nativeQuery = true)
    public void markTaskAsFinished(@Param("id") Long id);
}
