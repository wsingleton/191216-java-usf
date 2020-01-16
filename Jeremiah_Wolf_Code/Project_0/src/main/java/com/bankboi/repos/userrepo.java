package com.bankboi.repos;

import java.util.List;

import com.bankboi.DatabaseLayer.UserData;
import com.bankboi.plainjava.Users;

public class userrepo {

    static UserData user = new UserData();

    public List<Users> findAllUsers() {

        return user.findAll();

    }

    public Users findUser(int id) {

        return user.findById(id);

    }

    public Users saveUser(Users obj) {

        return user.save(obj);

    }

    public Users updateUser(Users obj) {

        return user.update(obj);

    }


}