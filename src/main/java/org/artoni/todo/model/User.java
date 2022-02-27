package org.artoni.todo.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    @OneToMany(mappedBy = "user")
    private List<Task> tasks;

    private User() {}

    public User(String username) {
        this.username = username;
    }

    public User(String username, List<Task> tasks) {
        this.username = username;
        this.tasks = tasks;
    }

    public String getUsername() {
        return username;
    }

    public List<Task> getTasks() {
        return tasks;
    }

}
