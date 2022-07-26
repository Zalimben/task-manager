package com.szalimben.taskmanager.repository;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.szalimben.taskmanager.domain.Project;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProjectRepositoryIntegrationTest
{
    @Autowired
    IProjectRepository projectRepository;

    @Test
    void saveProject()
    {
        Project newProject = new Project("New Project", LocalDate.now());
        assertThat(projectRepository.save(newProject), is(notNullValue()));
    }

    @Test
    void saveExistingProjectTest()
    {
        Project newProject = new Project("Save Existing Project", LocalDate.now());
        projectRepository.save(newProject);
        Optional<Project> storedProject = projectRepository.findById(newProject.getId());
        assertEquals(storedProject.get().getId(), newProject.getId());
    }

    @Test
    void findByNameTest()
    {
        Project newProject = new Project("Manhattam Project", LocalDate.now());
        projectRepository.save(newProject);
        Optional<Project> savedProject = projectRepository.findByName(newProject.getName());
        assertEquals(savedProject.get(), newProject);
    }

    @Test
    void findByDateTest()
    {
        Project newProject = new Project("New Project A", LocalDate.now().minusDays(5));
        projectRepository.save(newProject);
        newProject = new Project("New Project B", LocalDate.now().minusYears(12));
        projectRepository.save(newProject);
        newProject = new Project("New Project C", LocalDate.now().minusYears(5));
        projectRepository.save(newProject);

        List<Project> savedProjects = projectRepository.findByDateCreatedBetween(LocalDate.now().minusDays(8), LocalDate.now().minusDays(3));
        assertEquals(savedProjects.size(), 1);
    }
}
