package com.example.demo.service.impl;

import com.example.demo.entity.Task;
import com.example.demo.repository.TaskRepo;
import com.example.demo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    TaskRepo taskRepo;

    @Override
    public void saveTask(Task task) {
        taskRepo.save(task);
    }

    @Override
    public Task findById(int id) {
        return taskRepo.getOne(id);
    }
}
