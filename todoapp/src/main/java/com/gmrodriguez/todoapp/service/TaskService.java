package com.gmrodriguez.todoapp.service;

import com.gmrodriguez.todoapp.exceptions.ToDoExceptions;
import com.gmrodriguez.todoapp.mapper.TaskInDTOToTask;
import com.gmrodriguez.todoapp.persistence.entity.*;
import com.gmrodriguez.todoapp.persistence.repository.TaskRepository;
import com.gmrodriguez.todoapp.service.dto.TaskInDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

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

    @Transactional
    public void markTaskAsFinished(Long id) {
        Optional<Task> optionalTaks = taskRepository.findById(id);

        if(optionalTaks.isEmpty()) {
            throw new ToDoExceptions("Task not found", HttpStatus.NOT_FOUND);
        }

        taskRepository.markTaskAsFinished(id);
    }

    @Transactional
    public void deleteTask(Long id) {
        Optional<Task> optionalTaks = taskRepository.findById(id);

        if(optionalTaks.isEmpty()) {
            throw new ToDoExceptions("Task not found", HttpStatus.NOT_FOUND);
        }

        taskRepository.deleteById(id);
    }
}
