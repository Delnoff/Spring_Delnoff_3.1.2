package com.delnoff.springboot.sringovoe_crud_boot.dao;


import com.delnoff.springboot.sringovoe_crud_boot.model.User;

import java.util.List;

public interface UserDao {
    void create(User user);
    List<User> read();
    void update(long id, User user);
    void delete(long id);
    User showId(long id);
}
