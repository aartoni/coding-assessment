package org.artoni.todo.service;

import org.artoni.todo.model.Task;
import org.artoni.todo.model.User;
import org.artoni.todo.repository.UsersRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TasksServiceTest {

    @Mock
    private UsersRepository usersRepository;

    @InjectMocks
    private TasksService tasksService;

    @Test
    public void shouldAddAndRetrieveTasks() {
        List<Task> tasks = new ArrayList<>();
        Task task = new Task("Test title", "Test text", false, null, LocalDateTime.now());
        tasks.add(task);
        User user = new User("first-user", tasks);
        when(usersRepository.findById(anyLong())).thenReturn(Optional.of(user));

        tasksService.addTask(task, "first-user");
        assertEquals(tasks, tasksService.getTasks("first-user"));
    }

}
