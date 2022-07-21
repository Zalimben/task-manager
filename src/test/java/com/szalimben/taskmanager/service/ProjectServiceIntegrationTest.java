package com.szalimben.taskmanager.service;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.Optional;

import com.szalimben.taskmanager.domain.Project;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringBootTest
public class ProjectServiceIntegrationTest
{
    @Autowired
    private IProjectService projectService;

    @Test
    void saveNewProjectTest() {
        Project newProject = new Project("Test Project", LocalDate.now());
        Project savedProject = projectService.saveProject(newProject);
        assertThat(savedProject, is(notNullValue()));

        Optional<Project> storedProject = projectService.findById(newProject.getId());
        assertEquals( storedProject.get().getId(), newProject.getId());
    }
}
