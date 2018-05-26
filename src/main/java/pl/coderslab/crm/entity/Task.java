package pl.coderslab.crm.entity;

import org.springframework.beans.factory.annotation.Autowired;
import pl.coderslab.crm.converter.ProjectConverter;
import pl.coderslab.crm.services.TaskServiceImpl;

import javax.persistence.Id;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;



@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
//    @NotEmpty
    private LocalDateTime creationDate;
    @NotEmpty
    private String topic;
    @ManyToOne
    @Convert(converter = ProjectConverter.class)
    private Project project;
    private String description;
    @OneToOne
    private Status status;
    @OneToOne
    private Priority priority;
    @ManyToMany
    private List<User> users;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }


}
