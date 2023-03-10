package com.gmrodriguez.todoapp.controller;

import com.gmrodriguez.todoapp.persistence.entity.*;
import com.gmrodriguez.todoapp.service.TaskService;
import com.gmrodriguez.todoapp.service.dto.TaskInDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public Task createTask(@RequestBody TaskInDTO taskInDTO) {
        return taskService.createTask(taskInDTO);
    }

    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/status/{status}")
    public List<Task> getTaskByStatus(@PathVariable TaskStatus status) {
        return taskService.getTaskByStatus(status);
    }

    @PatchMapping("/{id}/finished")
    public ResponseEntity<Void> markTaskAsFinished(@PathVariable Long id) {
        taskService.markTaskAsFinished(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }
}
