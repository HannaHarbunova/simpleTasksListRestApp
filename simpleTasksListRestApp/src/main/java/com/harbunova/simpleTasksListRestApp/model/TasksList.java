package com.harbunova.simpleTasksListRestApp.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "TASKS_LIST")
public class TasksList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TASKS_ID", nullable = false)
    private Long id;

    @Column(name = "DESCRIPTION", nullable = false)
    private String description;

    public TasksList() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TasksList)) return false;
        TasksList that = (TasksList) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getDescription(), that.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDescription());
    }

    @Override
    public String toString() {
        return "TasksList{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}
