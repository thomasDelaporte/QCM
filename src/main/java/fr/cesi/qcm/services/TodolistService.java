package fr.cesi.qcm.services;

import java.util.List;

import fr.cesi.qcm.models.Task;
import fr.cesi.qcm.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodolistService {
	
	@Autowired
    TaskRepository taskRepository;

	public void createTask(String title) {
		taskRepository.save(new Task(title));
	}

	public List<Task> getTodoList() {
		return taskRepository.findAll();
	}
}
