package com.szalimben.taskmanager.domain;

import java.time.LocalDate;
import java.util.Random;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Project
{
    @Id
    private Long id;
    private String name;
    private LocalDate dateCreated;

    // A Project can have 0 or more tasks:
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "project_id")
    private Set<Task> tasks;

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
    public boolean equals(Object obj)
    {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }

        Project other = (Project) obj;
        if (dateCreated == null) {
            if (other.dateCreated != null) {
                return false;
            }
        } else if (!dateCreated.equals(other.dateCreated)) {
            return false;
        }
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        if (name == null) {
            return other.name == null;
        } else {
            return name.equals(other.name);
        }
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
