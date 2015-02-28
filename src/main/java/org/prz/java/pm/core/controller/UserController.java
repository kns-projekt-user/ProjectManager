package org.prz.java.pm.core.controller;

import org.prz.java.pm.core.entity.User;
import org.prz.java.pm.core.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Roman on 2015-02-26.
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UsersService usersService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<User> getAll() throws SQLException {
        return usersService.getAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getById(@PathVariable("id") Long id) throws SQLException {
        return usersService.getById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id) throws SQLException{
        usersService.delete(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public void save(@RequestBody User user) throws SQLException{
        usersService.save(user);
    }
}
