package com.banking.repo;

import java.util.List;

import com.banking.dao.UserDao;
import com.banking.pojos.User;

public class UserRepo {

    static UserDao user = new UserDao();

    public List<User> retriveAllUsers() {

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