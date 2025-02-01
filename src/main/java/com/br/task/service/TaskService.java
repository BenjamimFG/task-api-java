package com.br.task.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.br.task.dto.request.TaskRequestDTO;
import com.br.task.dto.response.TaskResponseDTO;
import com.br.task.entity.Task;
import com.br.task.repository.TaskRepository;

@Service
public class TaskService {

  private final TaskRepository taskRepository;

  public TaskService(TaskRepository taskRepository) {
    this.taskRepository = taskRepository;
  }

  public List<TaskResponseDTO> getTasks() {
    List<Task> tasks = this.taskRepository.findAll();

    return tasks.stream()
        .map(task -> new TaskResponseDTO(
            task.getId(),
            task.getTitle(),
            task.getDescription(),
            task.getStatus(),
            task.getPriority(),
            task.getDueDate()))
        .collect(Collectors.toList());
  }

  public TaskResponseDTO createTask(TaskRequestDTO taskRequest) {
    Task task = new Task(taskRequest.getTitle(), taskRequest.getDescription(), taskRequest.getPriority(),
        taskRequest.getDueDate());

    Task savedTask = this.taskRepository.save(task);

    return new TaskResponseDTO(savedTask.getId(), savedTask.getTitle(), savedTask.getDescription(),
        savedTask.getStatus(), savedTask.getPriority(), savedTask.getDueDate());
  }
}
