package org.artoni.todo;

import org.artoni.todo.controller.LoginController;
import org.artoni.todo.controller.TasksController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class ApplicationTests {

	@Autowired
	private TasksController tasksController;

	@Autowired
	private LoginController loginController;

	@Test
	void contextLoads() {
		assertThat(tasksController).isNotNull();
		assertThat(loginController).isNotNull();
	}

}
