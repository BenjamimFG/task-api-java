package com.br.task.service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;

import com.br.task.dto.request.TaskRequestDTO;
import com.br.task.dto.response.TaskResponseDTO;
import com.br.task.entity.Task;
import com.br.task.exception.TaskNotFoundException;
import com.br.task.repository.TaskRepository;

@Service
public class TaskService {

  private static final Logger logger = LoggerFactory.getLogger(TaskService.class);
  private final TaskRepository taskRepository;

  public TaskService(TaskRepository taskRepository) {
    this.taskRepository = taskRepository;
  }

  public List<TaskResponseDTO> getTasks() {
    logger.info("Iniciando o método de busca de task");
    List<Task> tasks = this.taskRepository.findAll();
    logger.info("Finalizando a busca de todas as tasks");
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
    logger.info("Iniciando a criação de uma task");
    Task task = new Task(taskRequest.getTitle(), taskRequest.getDescription(), taskRequest.getPriority(),
        taskRequest.getDueDate());

    Task savedTask = this.taskRepository.save(task);

    logger.info("Task criada com sucesso, ID:{} Titulo:{} Descricao{} ", savedTask.getId(), savedTask.getTitle(),
        savedTask.getDescription());

    return new TaskResponseDTO(savedTask.getId(), savedTask.getTitle(), savedTask.getDescription(),
        savedTask.getStatus(), savedTask.getPriority(), savedTask.getDueDate());
  }

  public TaskResponseDTO updateTask(String id, TaskRequestDTO taskRequest) {
    logger.info("Iniciando o update da task com ID: {}", id);
    Task task = this.taskRepository.findById(id)
        .orElseThrow(() -> new TaskNotFoundException("Task not found with ID: " + id));
    task.setTitle(taskRequest.getTitle());
    task.setDescription(taskRequest.getDescription());
    task.setDueDate(taskRequest.getDueDate());
    Task updateTask = this.taskRepository.save(task);
    logger.info("Finalizando o update da task com ID: {}", updateTask.getId());
    return new TaskResponseDTO(updateTask.getId(),
        updateTask.getTitle(),
        updateTask.getDescription(),
        updateTask.getStatus(),
        updateTask.getPriority(),
        updateTask.getDueDate());

  }

  public TaskResponseDTO getById(String id) {
    logger.info("Iniciando a busca por uma task com ID: {}", id);
    Task task = this.taskRepository.findById(id)
        .orElseThrow(() -> new TaskNotFoundException("Task not found with id: " + id));
    logger.info("Finalizando a busca por uma task ID: {}", task.getId());
    return new TaskResponseDTO(
        task.getId(),
        task.getTitle(),
        task.getDescription(),
        task.getStatus(),
        task.getPriority(),
        task.getDueDate());
  }

  public void deleteTask(String id) {
    logger.info("Iniciando a deleta uma task com ID: {}", id);
    Task task = this.taskRepository.findById(id)
        .orElseThrow(() -> new TaskNotFoundException("Task not found with id: " + id));
    logger.info("Finalizando a deleta uma task com ID: {}", task.getId());
    this.taskRepository.delete(task);
  }
}
