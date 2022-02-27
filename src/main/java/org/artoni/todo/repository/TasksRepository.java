package org.artoni.todo.repository;

import org.artoni.todo.model.Task;
import org.springframework.data.repository.CrudRepository;

public interface TasksRepository extends CrudRepository<Task, Long> { }
