package fr.cesi.qcm.controllers;

import java.util.ArrayList;
import java.util.List;

import fr.cesi.qcm.models.Task;
import fr.cesi.qcm.dto.TodoDTO;
import fr.cesi.qcm.services.TodolistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TodolistController {

	@Autowired
    TodolistService todolistService;

	@PostMapping("todos")
	public void saveItem(@RequestBody Task item) {

		System.out.println("Saving fais ton diapo task: "+item);
		todolistService.createTask(item.getTitle());
	}
	
	@GetMapping("todos")
	public List<TodoDTO> getTodoList() {

		List<TodoDTO> listToReturn = new ArrayList<TodoDTO>();
		
		List<Task> listFromDatabase = todolistService.getTodoList();
		for (Task task : listFromDatabase) {
			listToReturn.add(new TodoDTO(task.getTitle()));
		}
		
		return listToReturn;
	}
}
