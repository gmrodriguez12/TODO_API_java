package com.gmrodriguez.todoapp.mapper;

import com.gmrodriguez.todoapp.persistence.entity.*;
import com.gmrodriguez.todoapp.service.dto.TaskInDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TaskInDTOToTask implements IMapper <TaskInDTO, Task>{
    @Override
    public Task map(TaskInDTO input) {
        Task task = new Task();
        task.setTitle(input.getTitle());
        task.setDescription(input.getDescription());
        task.setEta(input.getEta());
        task.setStatus(TaskStatus.ON_TIME);
        task.setCreatedDate(LocalDateTime.now());
        task.setFinished(false);
        return task;
    }
}
