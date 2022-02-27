package org.artoni.todo.service;

import org.artoni.todo.model.Task;
import org.artoni.todo.model.User;
import org.artoni.todo.repository.TasksRepository;
import org.artoni.todo.repository.UsersRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TasksServiceTest {

    @Mock
    private UsersRepository usersRepository;

    @Mock
    private TasksRepository tasksRepository;

    @InjectMocks
    private TasksService tasksService;

    @Test
    void shouldAddAndRetrieveTasks() {
        List<Task> tasks = new ArrayList<>(1);
        Task task = new Task("Test title", "Test text", null, LocalDateTime.now());
        tasks.add(task);
        User user = new User("first-user", tasks);
        when(usersRepository.findByUsername("first-user")).thenReturn(user);
        when(tasksRepository.save(task)).thenReturn(task);

        tasksService.addTask(task, "first-user");
        assertEquals(tasks, tasksService.getTasks("first-user"), "Should return the added task");
    }

}
