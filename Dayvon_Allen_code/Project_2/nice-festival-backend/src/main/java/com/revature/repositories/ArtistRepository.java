package com.revature.repositories;

import com.revature.models.Artist;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ArtistRepository implements CrudRepository<Artist> {

    private SessionFactory sessionFactory;

    @Autowired
    public ArtistRepository(SessionFactory factory) {
        super();
        this.sessionFactory = factory;
    }
    @Override
    public List<Artist> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Artist", Artist.class).getResultList();
    }

    @Override
    public Artist findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Artist.class, id);
    }

    @Override
    public Artist save(Artist newOjb) {
        Session session = sessionFactory.getCurrentSession();
        session.save(newOjb);
        return newOjb;
    }

    @Override
    public Artist update(Artist updatedObj) {
        Session session = sessionFactory.getCurrentSession();
        Artist updatedArtist = session.load(Artist.class, updatedObj.getId());
        updatedArtist.setTime(updatedObj.getTime());
        updatedArtist.setStage(updatedObj.getStage());
        updatedArtist.setStatus(updatedObj.getStatus());
        return updatedArtist;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }
}
