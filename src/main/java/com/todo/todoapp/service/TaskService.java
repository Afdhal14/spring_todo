package com.todo.todoapp.service;

import com.todo.todoapp.models.Task;
import com.todo.todoapp.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository repo;

    public TaskService(TaskRepository repo) {
        this.repo = repo;
    }

    public List<Task> getTask() {
        return  repo.findAll();
    }
}
