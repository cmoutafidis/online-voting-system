package com.wannabeprogrammers.service;

import com.wannabeprogrammers.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class UserService {

    @PersistenceContext(unitName = "online_voting_systemDS")
    EntityManager entityManager;

    public User createUser(final User todo) {
        this.entityManager.persist(todo);
        return todo;
    }

    public User updateUser(final User todo) {
        this.entityManager.merge(todo);
        return todo;
    }

    public User findUserById(final long id) {
        return this.entityManager.find(User.class, id);
    }

    public List<User> getUsers() {
        return this.entityManager.createNativeQuery("SELECT id FROM user", User.class).getResultList();
    }
}
