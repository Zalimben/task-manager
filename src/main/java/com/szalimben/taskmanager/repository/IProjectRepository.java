package com.szalimben.taskmanager.repository;

import com.szalimben.taskmanager.domain.Project;
import org.springframework.data.repository.CrudRepository;

public interface IProjectRepository extends CrudRepository<Project, Long>
{

}
