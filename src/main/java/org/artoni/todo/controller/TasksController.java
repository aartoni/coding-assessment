package org.artoni.todo.controller;

import org.artoni.todo.model.Task;
import org.artoni.todo.service.TasksService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;

@Controller
public class TasksController {

    private final TasksService tasksService;

    TasksController(TasksService tasksService) {
        this.tasksService = tasksService;
    }

    @GetMapping("/tasks")
    public String tasks(Principal principal, Model model) {
        List<Task> tasks = tasksService.getTasks(principal.getName());
        model.addAttribute("tasks", tasks);
        return "tasks";
    }

    @GetMapping("/add-task")
    public static String addTaskGet() {
        return "add-task";
    }

    @PostMapping("/add-task")
    public String addTaskPost(Principal principal, @ModelAttribute Task task) {
        task.setChecked(false);
        task.setLastUpdate(LocalDateTime.now());
        tasksService.addTask(task, principal.getName());
        return "redirect:/tasks";
    }

    @GetMapping("/invert-task/{id}")
    public String checkTask(@PathVariable Long id) {
        tasksService.invertTaskStatus(id);
        return "redirect:/tasks";
    }

    @GetMapping("/remove-task/{id}")
    public String removeTask(@PathVariable Long id) {
        tasksService.removeTask(id);
        return "redirect:/tasks";
    }

}
