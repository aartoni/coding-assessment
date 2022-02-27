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
    private boolean checked;
    private LocalDateTime lastUpdate;

    @ManyToOne
    private User user;

    /**
     * Needed for JPA
     */
    private Task() {}

    public Task(String title, String text, User user, LocalDateTime lastUpdate) {
        this.title = title;
        this.text = text;
        this.user = user;
        this.lastUpdate = lastUpdate;
        checked = false;
    }

    /**
     * Used by Thymeleaf
     * @return task identifier
     */
    public Long getId() {
        return id;
    }

    /**
     * Used by Thymeleaf
     * @return task title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Used by Thymeleaf
     * @return task text/description
     */
    public String getText() {
        return text;
    }

    /**
     * Used by Thymeleaf
     * @return last update date and time
     */
    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
