package com.harbunova.simpleTasksListRestApp.repository;

import com.harbunova.simpleTasksListRestApp.model.TasksList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskListRepository extends JpaRepository<TasksList,Long> {
}
