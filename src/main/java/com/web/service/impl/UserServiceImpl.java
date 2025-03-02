package com.web.service.impl;


import com.web.dao.UserDao;
import com.web.domain.User;
import com.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public boolean save(User user) {
        return userDao.save(user) > 0;
    }

    @Override
    public boolean updateName(Integer id, String name) {
        return userDao.updateName(id, name) > 0;
    }

    @Override
    public boolean updatePwd(Integer id, String pwd) {
        return userDao.updatePwd(id, pwd) > 0;
    }

    @Override
    public boolean delete(Integer id) {
        return userDao.delete(id) > 0;
    }

    @Override
    public User getById(Integer id) {
        return userDao.getById(id);
    }

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Override
    public String login(String name,String pwd) {
        return userDao.login(name);
    }


}
