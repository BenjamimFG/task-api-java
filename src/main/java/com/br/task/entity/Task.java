package com.br.task.entity;

import java.util.Date;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Task {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;
  private String title;
  private String description;
  private TaskStatus status;
  private TaskPriority priority;
  private Date dueDate;

  public Task(String id, String title, String description, TaskStatus status, TaskPriority priority, Date dueDate) {
    this.id = id;
    this.title = title;
    this.description = description;
    this.status = status;
    this.priority = priority;
    this.dueDate = dueDate;
  }

  public Task() {
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public TaskStatus getStatus() {
    return status;
  }

  public void setStatus(TaskStatus status) {
    this.status = status;
  }

  public TaskPriority getPriority() {
    return priority;
  }

  public void setPriority(TaskPriority priority) {
    this.priority = priority;
  }

  public Date getDueDate() {
    return dueDate;
  }

  public void setDueDate(Date dueDate) {
    this.dueDate = dueDate;
  }

}
