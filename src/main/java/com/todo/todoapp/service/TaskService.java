package com.todo.todoapp.service;

import com.todo.todoapp.models.Task;
import com.todo.todoapp.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository repo;

    public TaskService(TaskRepository repo) {
        this.repo = repo;
    }

    public List<Task> getTask() {
        return  repo.findAll();
    }

    public void createTask(String title) {
        Task task = new Task();
        task.setTitle(title);
        task.setCompleted(false);
        repo.save(task);
    }

    public void deleteTask(Long id) {
        repo.deleteById(id);
    }

    public void toggleTask(Long id) {
            Task task = repo.findById(id).orElseThrow(()-> new IllegalArgumentException("Invalid task id"));
            task.setCompleted(!task.isCompleted());
            repo.save(task);
    }
}
