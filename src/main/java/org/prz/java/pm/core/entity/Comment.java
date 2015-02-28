package org.prz.java.pm.core.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Roman on 2015-02-16.
 */
@Entity
@Table(name = "comment")
public class Comment extends BaseEntity{

    @Column(name="content", nullable = false)
    private String content;

    @Column(name="create_date", nullable = false)
    private Date createDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="creator_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="task_id")
    private Task task;

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
