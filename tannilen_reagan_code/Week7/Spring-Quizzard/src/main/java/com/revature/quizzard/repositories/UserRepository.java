package com.revature.quizzard.repositories;

import com.revature.quizzard.entities.AppUser;
import com.revature.quizzard.web.dtos.Credentials;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository implements CRUDRepository<AppUser> {
    private SessionFactory sessionFactory;

    @Autowired
    public UserRepository(SessionFactory sessionFactory) {
        super();
        this.sessionFactory=sessionFactory;
    }

    public AppUser findUserByCredentials(Credentials c) {
        try(Session session=sessionFactory.getCurrentSession()) {
            return session.createQuery("FROM APPUSER a WHERE a.usernmae=:un and a.password=:pw", AppUser.class).setParameter("un", c.getUsername()).setParameter("pw", c.getPassword()).getSingleResult();
        }
    }

    @Override
    public List<AppUser> findAll() {
        List<AppUser> users=new ArrayList<>();
        try(Session session=sessionFactory.getCurrentSession()) {
            users=session.createQuery("FROM APPUSER", AppUser.class).getResultList();
        }
        return users;
    }

    @Override
    public AppUser findById(int id) {
        try(Session session=sessionFactory.getCurrentSession()) {
            return session.get(AppUser.class, id);
        }
    }

    @Override
    public AppUser save(AppUser obj) {
        try(Session session=sessionFactory.getCurrentSession()) {
            return (AppUser) session.save(obj);
        }
    }

    @Override
    public boolean update(AppUser obj) {
        return false;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }
}