package com.szalimben.taskmanager;

import java.time.LocalDate;
import javax.annotation.PostConstruct;

import com.szalimben.taskmanager.domain.Project;
import com.szalimben.taskmanager.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TaskManagerApplication {

	@Autowired
	private IProjectService projectService;

	public static void main(String[] args) {
		SpringApplication.run(TaskManagerApplication.class, args);
	}

	@PostConstruct
	public void exampleProjects() {
//		projectService.saveProject(new Project("Manhattan Project", LocalDate.now()));
	}

}
