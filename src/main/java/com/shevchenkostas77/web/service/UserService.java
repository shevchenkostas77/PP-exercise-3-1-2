package com.shevchenkostas77.web.service;

import com.shevchenkostas77.web.model.User;

import java.util.List;

public interface UserService {
    void create(User user);

    User read(Long id);

    List<User> readAll();

    void update(Long id, String name, String lastName, String email);

    void delete(Long id);
}
