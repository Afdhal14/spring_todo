package com.todo.todoapp.controller;

import com.todo.todoapp.models.Task;
import com.todo.todoapp.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TaskController {
    private final TaskService service;

    //Constructor Injection
    public TaskController(TaskService service) {
        this.service = service;
    }

    @GetMapping
    public String getTask(Model model){
        List<Task> tasks = service.getTask();
        model.addAttribute("tasks",tasks);
        return "tasks";//Return the tasks to HTML which is named as tasks
    }

    @PostMapping
    public String createTask(String title){
        service.createTask(title);
        return "redirect:/";
    }

    @GetMapping("/{id}/delete")
    public String deleteTask(@PathVariable Long id)
    {
        service.deleteTask(id);
        return"redirect:/";
    }

    @GetMapping("/{id}/toggle")
    public String toggleTask(@PathVariable Long id){
        service.toggleTask(id);
        return "redirect:/";
    }
}
