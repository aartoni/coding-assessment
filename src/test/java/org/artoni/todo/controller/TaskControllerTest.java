package org.artoni.todo.controller;

import org.artoni.todo.model.Task;
import org.artoni.todo.service.TasksService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = TasksController.class)
class TaskControllerTest {

    private final MockMvc mockMvc;

    @MockBean
    private TasksService tasksService;

    @Autowired
    TaskControllerTest(MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

    @Test
    void shouldAddTask() throws Exception {
        Task task = new Task("Test title", "Test text", null, LocalDateTime.now());
        mockMvc.perform(post("/add-task").with(user("first-user"))
                        .flashAttr("task", task)).andDo(print())
                .andExpect(status().is3xxRedirection());
    }

    @Test
    void shouldRetrieveTasks() throws Exception {
        List<Task> tasks = new ArrayList<>(1);
        tasks.add(new Task("Test title", "Test text", null, LocalDateTime.now()));
        when(tasksService.getTasks("first-user")).thenReturn(tasks);

        mockMvc.perform(get("/tasks").with(user("first-user"))).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Test title")))
                .andExpect(content().string(containsString("Test text")))
                .andExpect(content().string(containsString("Check")));
    }

    @Test
    void shouldCheckTask() throws Exception {
        doNothing().when(tasksService).invertTaskStatus(anyLong());

        mockMvc.perform(get("/invert-task/1").with(user("first-user"))).andDo(print())
                .andExpect(status().is3xxRedirection());
    }

    @Test
    void shouldDeleteTask() throws Exception {
        doNothing().when(tasksService).removeTask(anyLong());

        mockMvc.perform(get("/remove-task/1").with(user("first-user"))).andDo(print())
                .andExpect(status().is3xxRedirection());
    }

    @Test
    void shouldDisplayTaskCreationPage() throws Exception {
        mockMvc.perform(get("/add-task").with(user("first-user"))).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Task creation")));
    }

    @Test
    void shouldDisplayTaskListPage() throws Exception {
        mockMvc.perform(get("/tasks").with(user("first-user"))).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Tasks list")));
    }

}
