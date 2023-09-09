package com.shevchenkostas77.web.service;


import com.shevchenkostas77.web.dao.UserDao;
import com.shevchenkostas77.web.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    @Override
    @Transactional
    public void create(User user) {
        userDao.save(user);
    }

    @Override
    public User read(Long id) {
        return userDao.findById(id).get();
    }

    @Override
    public List<User> readAll() {
        return userDao.findAll();
    }

    @Override
    @Transactional
    public void update(Long id, String name, String lastName, String email) {
        userDao.updateUser(id, name, lastName, email);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        userDao.deleteById(id);
    }
}
