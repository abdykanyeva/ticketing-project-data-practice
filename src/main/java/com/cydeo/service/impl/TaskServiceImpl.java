package com.cydeo.service.impl;

import com.cydeo.dto.TaskDTO;
import com.cydeo.entity.Task;
import com.cydeo.enums.Status;
import com.cydeo.mapper.TaskMapper;
import com.cydeo.repository.TaskRepository;
import com.cydeo.service.TaskService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    public TaskServiceImpl(TaskRepository taskRepository, TaskMapper taskMapper) {
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
    }


    @Override
    public void save(TaskDTO taskDTO) {

        taskDTO.setTaskStatus(Status.OPEN);
        taskDTO.setAssignedDate(LocalDate.now());

        taskRepository.save(taskMapper.convertToEntity(taskDTO));
    }

    @Override
    public void update(TaskDTO taskDTO) {

        Task task = taskRepository.findById(taskDTO.getId()).get();

        Task convertedTask = taskMapper.convertToEntity(taskDTO);

        convertedTask.setTaskStatus(task.getTaskStatus());
        convertedTask.setAssignedDate(task.getAssignedDate());

        taskRepository.save(task);
    }

    @Override
    public void delete(Long id) {

        Task task = taskRepository.findById(id).get();
        task.setIsDeleted(true);
        taskRepository.save(task);

    }

    @Override
    public List<TaskDTO> listAllTasks() {
        return taskRepository.findAll()
                .stream()
                .map(taskMapper::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TaskDTO findById(Long id) {

        Task task = taskRepository.findById(id).get();


        return taskMapper.convertToDTO(task);
    }

    @Override
    public int totalNonCompletedTask(String projectCode) {
        return taskRepository.totalNonCompletedTask(projectCode);
    }

    @Override
    public int totalCompletedTask(String projectCode) {
        return taskRepository.totalCompletedTask(projectCode);
    }
}
