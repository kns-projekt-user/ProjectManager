package org.prz.java.pm.core.dao;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.prz.java.pm.core.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Roman on 2015-02-16.
 */

@Repository
@Transactional
public class UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public List<User> getAll() throws SQLException{
        Criteria users = sessionFactory.getCurrentSession().createCriteria(User.class);
        return users.list();
    }

    public User getById(Long id) throws  SQLException{
        List<User> users = sessionFactory.getCurrentSession().createCriteria(User.class).add(Restrictions.eq("id",id)).list();
        return users.get(0);
    }

    public void delete(Long id) throws  SQLException{
        sessionFactory.getCurrentSession().delete(getById(id));
    }

    public void save(User user) throws SQLException{
        sessionFactory.getCurrentSession().save(user);
    }
}
