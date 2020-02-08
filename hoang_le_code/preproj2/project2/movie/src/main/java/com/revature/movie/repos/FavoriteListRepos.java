package com.revature.movie.repos;

import com.revature.movie.model.FavoriteList;
import com.revature.movie.util.HibernateUtil;
import org.hibernate.Session;

public class FavoriteListRepos  {

    public FavoriteList findById(int id){

        FavoriteList l = new FavoriteList();

        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {

            session.beginTransaction();

            // .get() returns the actual persistent object associated with the DB records (eagerly-fetched)
             l = session.get(FavoriteList.class, id); // returns null if not found



        } catch (Exception e) {
            e.printStackTrace();
        }
        return l;

    }
}
