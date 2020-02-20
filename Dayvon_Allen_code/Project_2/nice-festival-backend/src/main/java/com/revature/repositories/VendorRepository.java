package com.revature.repositories;

import com.revature.models.User;
import com.revature.models.Vendor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class VendorRepository implements CrudRepository<Vendor> {

    private SessionFactory sessionFactory;

    @Autowired
    public VendorRepository(SessionFactory factory) {
        super();
        this.sessionFactory = factory;
    }
    @Override
    public List<Vendor> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Vendor", Vendor.class).getResultList();
    }

    @Override
    public Vendor findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Vendor.class, id);
    }

    @Override
    public Vendor save(Vendor newOjb) {
        Session session = sessionFactory.getCurrentSession();
        session.save(newOjb);
        return newOjb;
    }

    @Override
    public Vendor update(Vendor updatedObj) {
        Session session = sessionFactory.getCurrentSession();
        Vendor updatedVendor = session.load(Vendor.class, updatedObj.getId());
        updatedVendor.setTent(updatedObj.getTent());
        updatedVendor.setStatus(updatedObj.getStatus());
        return updatedVendor;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }
}
