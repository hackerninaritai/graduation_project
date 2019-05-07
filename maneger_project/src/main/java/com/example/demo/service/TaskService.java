package com.example.demo.service;


import com.example.demo.entity.Task;

public interface TaskService {
    void saveTask(Task task);

    Task findById(int id);

}
