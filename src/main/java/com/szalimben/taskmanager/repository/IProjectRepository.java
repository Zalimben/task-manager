package com.szalimben.taskmanager.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.szalimben.taskmanager.domain.Project;
import org.springframework.data.repository.CrudRepository;

public interface IProjectRepository extends CrudRepository<Project, Long>
{
    Optional<Project> findByName(String name);

    List<Project> findByDateCreatedBetween(LocalDate start, LocalDate end);

}
