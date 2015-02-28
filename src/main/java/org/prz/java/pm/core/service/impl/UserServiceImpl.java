package org.prz.java.pm.core.service.impl;

import org.prz.java.pm.core.dao.UserDAO;
import org.prz.java.pm.core.entity.User;
import org.prz.java.pm.core.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Roman on 2015-02-26.
 */

@Service
@Transactional
public class UserServiceImpl implements UsersService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public List<User> getAll() throws SQLException {
        return userDAO.getAll();
    }

    @Override
    public User getById(Long id) throws SQLException {
        return userDAO.getById(id);
    }

    @Override
    public void delete(Long id) throws SQLException{
        userDAO.delete(id);
    }

    @Override
    public void save(User user) throws SQLException {
        userDAO.save(user);
    }
}
