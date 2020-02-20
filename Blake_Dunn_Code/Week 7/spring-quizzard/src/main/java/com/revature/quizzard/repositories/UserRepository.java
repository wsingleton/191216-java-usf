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
public class UserRepository implements CrudRepository<AppUser> {

    private SessionFactory sessionFactory;

    @Autowired
    public UserRepository(SessionFactory factory) {
        super();
        this.sessionFactory = factory;
    }

    public AppUser findUserByCredentials(Credentials creds) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from AppUser au where au.username = :un and au.password = :pw", AppUser.class)
                .setParameter("un", creds.getUsername())
                .setParameter("pw", creds.getPassword())
                .getSingleResult();

    }

    @Override
    public List<AppUser> findAll() {

        List<AppUser> users = new ArrayList<>();

        Session session = sessionFactory.getCurrentSession();
        users = session.createQuery("from AppUser", AppUser.class).getResultList();


        return users;
    }

    @Override
    public AppUser findById(int id) {
        Session session = sessionFactory.getCurrentSession();
            return session.get(AppUser.class, id);

    }

    @Override
    public AppUser save(AppUser newObj) {
       Session session = sessionFactory.getCurrentSession();
       session.save(newObj);
       return newObj;

    }

    @Override
    public boolean update(AppUser updatedObj) {
        return false;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }
}
