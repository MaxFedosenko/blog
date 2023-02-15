package com.kam.blog.services;

import com.kam.blog.entities.User;

import java.util.List;

public interface UserService {

    User create(User user);
    User getByName(String name);
    User getById (Long id);
    List<User> getAll();
    void update(String newName, Long id);
    void delete(Long id);

}
