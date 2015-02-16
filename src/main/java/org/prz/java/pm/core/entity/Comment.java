package main.java.org.prz.java.pm.core.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by Roman on 2015-02-16.
 */
@Entity
@Table(name = "COMMENT")
public class Comment extends BaseEntity{

    @Column(name="content", nullable = false)
    private String content;

    @Column(name="create_date", nullable = false)
    private Date createDate;

    @ManyToOne
    private User users;

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

    public User getUsers() {
        return users;
    }

    public void setUsers(User users) {
        this.users = users;
    }
}
