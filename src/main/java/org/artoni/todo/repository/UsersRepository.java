package org.artoni.todo.repository;

import org.artoni.todo.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
