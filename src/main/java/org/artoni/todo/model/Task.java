package org.artoni.todo.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String text;
    private Boolean checked;
    private LocalDateTime lastUpdate;

    @ManyToOne
    private User user;

    private Task() {}

    public Task(String title, String text, Boolean checked, User user, LocalDateTime lastUpdate) {
        this.title = title;
        this.text = text;
        this.checked = checked;
        this.user = user;
        this.lastUpdate = lastUpdate;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public Boolean isChecked() {
        return checked;
    }

    public User getUser() {
        return user;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
