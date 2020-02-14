package com.revature.spring.repositories;

import com.revature.spring.AppConfig;
import com.revature.spring.entities.AppUser;

import com.revature.spring.web.dtos.Credentials;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class UserRepository implements CRUDRepository<AppUser>{

    private SessionFactory sessionFactory;

    public AppUser findUserByCredentials(Credentials creds){
        Session session = sessionFactory.getCurrentSession();
            return session.createQuery("from AppUser au where au.username = :un and au.password = :pw", AppUser.class)
                    .setParameter("un", creds.getUsername())
                    .setParameter("pw", creds.getPassword())
                    .getSingleResult();
    }

    @Autowired
    public UserRepository(SessionFactory factory){
        super();
        this.sessionFactory = factory;
    }

    @Override
    public List<AppUser> findAll() {


        Session session = sessionFactory.getCurrentSession();
           return  session.createQuery("from AppUser", AppUser.class).getResultList();
    }

    @Override
    public AppUser findById(int id) {

        Session session = sessionFactory.getCurrentSession();
            return session.get(AppUser.class, id);
    }

    @Override
    public AppUser save(AppUser newObj) {
        Session session = sessionFactory.getCurrentSession();
        //Transaction tx = session.beginTransaction();
            session.save(newObj);
            //tx.commit();
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
