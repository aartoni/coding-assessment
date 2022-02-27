package org.artoni.todo.repository;

import org.artoni.todo.model.Task;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TasksRepository extends CrudRepository<Task, Long> {

    // public Optional<Task> findById(Long id);

}
