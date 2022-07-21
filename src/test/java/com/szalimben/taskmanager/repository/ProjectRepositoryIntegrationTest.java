package com.szalimben.taskmanager.repository;

import static org.hamcrest.CoreMatchers.equalTo;
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

@SpringBootTest
public class ProjectRepositoryIntegrationTest
{
    @Autowired
    IProjectRepository iProjectRepository;

    @Test
    void saveProject() {
        Project newProject = new Project("New Project", LocalDate.now());
        assertThat( iProjectRepository.save(newProject), is(notNullValue()));
    }

    @Test
    void saveExistingProjectTest() {
        Project newProject = new Project("Save Existing Project", LocalDate.now());
        iProjectRepository.save(newProject);
        Optional<Project> storedProject = iProjectRepository.findById(newProject.getId());
        assertEquals( storedProject.get().getId(), newProject.getId());
    }
}
