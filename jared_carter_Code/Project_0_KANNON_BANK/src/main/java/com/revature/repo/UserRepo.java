package com.revature.repo;

import java.util.List;

import com.revature.dao.UserDao;
import com.revature.pojos.User;

public class UserRepo {

    static UserDao user = new UserDao();

    public List<User> findAllUsers() {

        return user.findAll();

    }

    public User findUser(int id) {

        return user.findById(id);

    }

    public User saveUser(User obj) {

        return user.save(obj);

    }

    public User updateUser(User obj) {

        return user.update(obj);

    }


}