package com.br.task.dto.request;

import com.br.task.entity.TaskPriority;
import com.br.task.entity.TaskStatus;

import java.util.Date;

public class TaskUpdateRequestDTO {
  private String title;
  private String description;
  private TaskPriority priority;
  private Date dueDate;
  private TaskStatus status;

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

  public TaskStatus getStatus() {
    return status;
  }

  public void setStatus(TaskStatus status) {
    this.status = status;
  }

}
