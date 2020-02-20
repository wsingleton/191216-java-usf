package com.revature.repositories;

import com.revature.models.Message;
import com.revature.models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MessageRepository implements CrudRepository<Message> {

    private SessionFactory sessionFactory;

    @Autowired
    public MessageRepository(SessionFactory factory) {
        super();
        this.sessionFactory = factory;
    }
    public List<Message> findAllBySenderId(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Message m where m.sender = :mes", Message.class)
                .setParameter("mes", id)
                .getResultList();
    }

    public List<Message> findAllByReceiverId(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Message m where m.receiver = :mes", Message.class)
                .setParameter("mes", id)
                .getResultList();
    }

    public List<Message> findByCorrespondingId(String correspondingId) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Message m where m.correspondingId = :cid", Message.class)
                      .setParameter("cid", correspondingId)
                      .getResultList();
    }

    @Override
    public List<Message> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Message", Message.class).getResultList();
    }

    @Override
    public Message findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Message.class, id);
    }

    @Override
    public Message save(Message newOjb) {
        Session session = sessionFactory.getCurrentSession();
        session.save(newOjb);
        return newOjb;
    }

    @Override
    public Message update(Message updatedObj) {
        return null;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }
}
