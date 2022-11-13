package com.cydeo.service;

import com.cydeo.dto.TaskDTO;
import com.cydeo.entity.Task;

import java.util.List;

public interface TaskService {

    // save, update, delete, show all tasks, give me certain tasks


    void save(TaskDTO taskDTO);
    void update(TaskDTO taskDTO);
    void delete(Long id);
    List<TaskDTO>listAllTasks();
    TaskDTO findById(Long id);

    int totalNonCompletedTask(String projectCode);
    int totalCompletedTask(String projectCode);
}
