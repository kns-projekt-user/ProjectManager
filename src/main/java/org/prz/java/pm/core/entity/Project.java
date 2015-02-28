package org.prz.java.pm.core.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Roman on 2015-02-16.
 */
@Entity
@Table(name = "project")
public class Project extends BaseEntity{

    @Column(name="name", nullable = false)
    private String name;

    @Column(name = "create_date", nullable = false)
    private Date createDate;

    @Column(name= "description", nullable = false)
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
