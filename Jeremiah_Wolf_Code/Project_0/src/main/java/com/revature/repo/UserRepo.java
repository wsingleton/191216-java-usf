package com.revature.repo;

import com.revature.dao.UserData;
import com.revature.pojos.User;

import java.util.List;

public class UserRepo {

    static UserData user = new UserData();

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