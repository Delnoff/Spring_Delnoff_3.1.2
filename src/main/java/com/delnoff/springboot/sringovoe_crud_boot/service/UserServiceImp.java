package com.delnoff.springboot.sringovoe_crud_boot.service;


import com.delnoff.springboot.sringovoe_crud_boot.dao.UserDao;
import com.delnoff.springboot.sringovoe_crud_boot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional
    public void create(User user) {
        userDao.create(user);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> read() {
        return userDao.read();
    }

    @Override
    @Transactional
    public void update(long id, User user) {
        userDao.update(id,user);
    }

    @Override
    @Transactional
    public void delete(long id) {
        userDao.delete(id);
    }

    @Override
    @Transactional(readOnly = true)
    public User showId(long id) {
        return userDao.showId(id);
    }
}
