package com.br.task.repository;

import org.springframework.stereotype.Repository;

import com.br.task.entity.Task;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface TaskRepository extends JpaRepository<Task, String> {
}
