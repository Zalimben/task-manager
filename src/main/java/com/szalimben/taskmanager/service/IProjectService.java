package com.szalimben.taskmanager.service;

import java.util.Optional;

import com.szalimben.taskmanager.domain.Project;

public interface IProjectService
{
    Optional<Project> findById(long id);

    Project saveProject(Project project);


}
