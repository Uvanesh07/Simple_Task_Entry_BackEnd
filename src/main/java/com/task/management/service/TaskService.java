package com.task.management.service;

import com.task.management.entity.TaskEntity;
import com.task.management.repository.TaskRepository;
import org.springframework.stereotype.Service;


@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public TaskEntity taskSubmit(String task) {
        if (task == null) {
            return null;
        }
        else {
            TaskEntity taskEntity = new TaskEntity();
            taskEntity.setTask(task);
            return taskRepository.save(taskEntity);
        }

    }

}