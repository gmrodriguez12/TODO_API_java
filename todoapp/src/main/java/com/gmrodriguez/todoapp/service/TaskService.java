package com.gmrodriguez.todoapp.service;

import com.gmrodriguez.todoapp.mapper.TaskInDTOToTask;
import com.gmrodriguez.todoapp.persistence.entity.*;
import com.gmrodriguez.todoapp.persistence.repository.TaskRepository;
import com.gmrodriguez.todoapp.service.dto.TaskInDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;
    private final TaskInDTOToTask mapper;

    public TaskService(TaskRepository taskRepository, TaskInDTOToTask mapper) {
        this.taskRepository = taskRepository;
        this.mapper = mapper;
    }

    public Task createTask(TaskInDTO taskInDTO) {
        return taskRepository.save(mapper.map(taskInDTO));
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public List<Task> getTaskByStatus(TaskStatus status) {
        return taskRepository.findAllByStatus(status);
    }
}
