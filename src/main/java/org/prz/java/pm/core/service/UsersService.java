package org.prz.java.pm.core.service;

import org.prz.java.pm.core.entity.User;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Roman on 2015-02-26.
 */
public interface UsersService {

    public List<User> getAll() throws SQLException;

    public User getById(Long id) throws SQLException;

    public void delete(Long id) throws SQLException;

    public void save(User user) throws SQLException;
}
