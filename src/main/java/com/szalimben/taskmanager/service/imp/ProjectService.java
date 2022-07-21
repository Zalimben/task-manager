package com.szalimben.taskmanager.service.imp;

import java.util.Optional;

import com.szalimben.taskmanager.domain.Project;
import com.szalimben.taskmanager.repository.IProjectRepository;
import com.szalimben.taskmanager.service.IProjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService implements IProjectService
{
    private final static Logger logger = LoggerFactory.getLogger(ProjectService.class);

    private final IProjectRepository projectRepository;

    @Autowired
    public ProjectService(IProjectRepository projectRepository)
    {
        this.projectRepository = projectRepository;
    }

    @Override
    public Optional<Project> findById(long id)
    {
        logger.debug("findById {}", id);
        return projectRepository.findById(id);
    }

    @Override
    public Project saveProject(Project project)
    {
        logger.debug("saveProject {}", project);
        return projectRepository.save(project);
    }
}
