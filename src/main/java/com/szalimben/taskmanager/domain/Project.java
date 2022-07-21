package com.szalimben.taskmanager.domain;

import java.time.LocalDate;
import java.util.Random;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Project
{
    @Id
    private Long id;
    private String name;
    private LocalDate dateCreated;

    public Project()
    {
    }

    public Project(String name, LocalDate dateCreated)
    {
        this.id = new Random().nextLong();
        this.name = name;
        this.dateCreated = dateCreated;
    }

    public Project(Project project)
    {
        this.id = project.id;
        this.name = project.name;
        this.dateCreated = project.dateCreated;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public LocalDate getDateCreated()
    {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated)
    {
        this.dateCreated = dateCreated;
    }

    @Override
    public String toString()
    {
        return "Project{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", dateCreated=" + dateCreated +
            '}';
    }
}
