package com.br.task.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.task.dto.request.TaskRequestDTO;
import com.br.task.dto.response.TaskResponseDTO;
import com.br.task.service.TaskService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/tasks")
public class TaskController {

  private final TaskService taskService;

  public TaskController(TaskService taskService) {
    this.taskService = taskService;
  }

  @GetMapping
  public ResponseEntity<List<TaskResponseDTO>> getTasks() {
    List<TaskResponseDTO> tasks = this.taskService.getTasks();

    return ResponseEntity.ok(tasks);
  }

  @PostMapping
  public ResponseEntity<TaskResponseDTO> createTask(@RequestBody TaskRequestDTO req) {
    TaskResponseDTO res = this.taskService.createTask(req);

    return ResponseEntity.status(201).body(res);
  }

  @GetMapping("/{id}")
  public ResponseEntity<TaskResponseDTO> getTaskById(@PathVariable String id) {
    TaskResponseDTO res = this.taskService.getById(id);

    return ResponseEntity.ok(res);
  }

}
