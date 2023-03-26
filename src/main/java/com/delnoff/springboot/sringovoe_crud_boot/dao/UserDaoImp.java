package com.delnoff.springboot.sringovoe_crud_boot.dao;

import com.delnoff.springboot.sringovoe_crud_boot.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void create(User user) {
        entityManager.persist(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> read() {
        return entityManager.createQuery("from User").getResultList();
    }

    @Override
    public void update(long id, User user) {
        User us = showId(id);
        us.setName(user.getName());
        us.setSurname(user.getSurname());
        us.setAge(user.getAge());
        entityManager.merge(us);
    }

    @Override
    public void delete(long id) {
        User user = showId(id);
        entityManager.remove(user);
    }

    @Override
    public User showId(long id) {
        return entityManager.find(User.class,id);
    }
}
