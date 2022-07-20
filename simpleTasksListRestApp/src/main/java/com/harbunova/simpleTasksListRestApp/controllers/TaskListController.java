package com.harbunova.simpleTasksListRestApp.controllers;

import com.harbunova.simpleTasksListRestApp.model.TasksList;
import com.harbunova.simpleTasksListRestApp.repository.TaskListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.stream.Collectors;

@CrossOrigin("http://localhost:63342/")
@RequestMapping("/api/v1/tasks")
@RestController
public class TaskListController {

    private final TaskListRepository repository;

    @Autowired
    public TaskListController(TaskListRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public TasksList createTasksList(@RequestBody TasksList tasksList) {
        return repository.save(tasksList);
    }

    @DeleteMapping("/{id}")
    public void deleteTaskItem(@PathVariable("id") Long id) {
        repository.deleteById(id);

    }

    @GetMapping("/all")
    public Map<Long, TasksList> findAllTaskItems() {
        return repository.findAll().stream().collect(Collectors.toMap(TasksList::getId, item->item));
    }
}
