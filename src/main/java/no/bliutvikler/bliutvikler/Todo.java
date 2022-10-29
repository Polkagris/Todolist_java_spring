package no.bliutvikler.bliutvikler;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
class Todo {
    private @Id @GeneratedValue Long id;
    private String title;
    private Boolean completed;

    // empty constructor
    Todo() {}

    // constructor
    Todo(String title, Boolean completed) {
        this.title = title;
        this.completed = completed;
    }

    // getters
    public Long getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public Boolean getCompleted() {
        return this.completed;
    }

    // setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
}
