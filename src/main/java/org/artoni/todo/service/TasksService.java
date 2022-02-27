package org.artoni.todo.service;

import org.artoni.todo.model.Task;
import org.artoni.todo.model.User;
import org.artoni.todo.repository.TasksRepository;
import org.artoni.todo.repository.UsersRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TasksService {

    Logger logger = LoggerFactory.getLogger(TasksService.class);

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    TasksRepository tasksRepository;

    public List<Task> getTasks(String username) {
        User user = usersRepository.findByUsername(username);
        return user.getTasks();
    }

    public void addTask(Task task, String username) {
        User user = usersRepository.findByUsername(username);
        task.setUser(user);
        logger.debug("Created task: {}", task);
        tasksRepository.save(task);
    }

    public void invertTaskStatus(Long id) {
        Task task = tasksRepository.findById(id).orElseThrow(NoSuchElementException::new);
        task.setChecked(!task.isChecked());
        tasksRepository.save(task);
    }

    public void removeTask(Long id) {
        Task task = tasksRepository.findById(id).orElseThrow(NoSuchElementException::new);
        tasksRepository.delete(task);
    }

}
