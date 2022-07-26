package com.szalimben.taskmanager.repository;

import java.util.List;

import com.szalimben.taskmanager.domain.Task;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ITaskRepository extends CrudRepository<Task, Long>
{
    @Query("select t from Task t where t.name like %?1%")
    List<Task> findByNameMatches(String name);
}
