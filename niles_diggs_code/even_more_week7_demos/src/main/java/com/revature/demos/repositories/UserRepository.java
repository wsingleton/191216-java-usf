package com.revature.demos.repositories;

import com.revature.demos.entities.AppUser;
import com.revature.demos.web.dtos.Credentials;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository implements CrudRepository {

    private SessionFactory sessionFactory;

    public AppUser findUserByCredentials(Credentials creds) {

        Session session = sessionFactory.getCurrentSession();
           return session.createQuery("from AppUser au where au.username =: un and au.password = :pw", AppUser.class)
                    .setParameter("un",creds.getUsername()).setParameter("pw", creds.getPassword())
                    .getSingleResult();
        }

    @Autowired
    public UserRepository(SessionFactory factory) {
        super();
        this.sessionFactory = factory;
    }

    @Override
    public List<AppUser> findAll() {
        List<AppUser> users = new ArrayList<>();

        Session session = sessionFactory.getCurrentSession();

            users = session.createQuery("from AppUser", AppUser.class).getResultList();

        return users;
    }

    @Override
    public Object findById(int id) {

        Session session = sessionFactory.getCurrentSession();
            return session.get(AppUser.class, id);
    }

    @Override
    public AppUser save(Object newObj) {
        Session session = sessionFactory.getCurrentSession();
            return (AppUser) session.save(newObj);
        }

    @Override
    public boolean update(Object updatedObJ) {
        return false;
    }

    @Override
    public boolean delete(Object updatedObJ) {
        return false;
    }
}
