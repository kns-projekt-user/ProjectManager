package org.prz.java.pm.core.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Roman on 2015-02-16.
 */
@Entity
@Table(name="task")
public class Task extends BaseEntity{

    public enum TaskStatus{
            OPEN("OPEN"), CLOSED("CLOSED"), RESOLVED("RESOLVED"), IN_PROGRESS("IN_PROGRESS");

        private String s;

        private TaskStatus(String s){
            this.setStatus(s);
        }

        public String getSatus() {
            return s;
        }

        public void setStatus(String s) {
            this.s = s;
        }
    }

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = true)
    private String description;

    @ManyToOne
    @JoinColumn(name = "creator_id")
    private User user;

    @ManyToOne
    @JoinColumn(name="project_id")
    private Project project;

    @Column(name = "creare_date", nullable = false)
    private Date createDate;

    @Column(name = "status", nullable = false)
    private TaskStatus status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}