package com.szalimben.taskmanager.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.List;

import com.szalimben.taskmanager.domain.Task;
import com.szalimben.taskmanager.domain.TaskStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TaskRepositoryIntegrationTest
{
    @Autowired
    ITaskRepository taskRepository;

    @Test
    void givenProjectCreatedThenFindByTaskNameMatchesSuccess()
    {
        Task task1 = new Task(
            "Low Priority Task", "Low Priority Task", TaskStatus.TO_DO, LocalDate.now(), LocalDate.now());
        Task task2 = new Task(
            "Low Priority Task", "Low Priority Task", TaskStatus.TO_DO, LocalDate.now(), LocalDate.now());
        Task task3 = new Task(
            "High Priority Task", "High Priority Task", TaskStatus.TO_DO, LocalDate.now(), LocalDate.now());
        Task task4 = new Task(
            "High Priority Task", "High Priority Task", TaskStatus.TO_DO, LocalDate.now(), LocalDate.now());

        taskRepository.save(task1);
        taskRepository.save(task2);
        taskRepository.save(task3);
        taskRepository.save(task4);

        List<Task> retreivedTasks = taskRepository.findByNameMatches("High");
        assertEquals(retreivedTasks.size(), 2);
    }
}
