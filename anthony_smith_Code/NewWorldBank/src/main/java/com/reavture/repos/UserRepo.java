package com.reavture.repos;

import java.util.List;

import com.reavture.dao.*;
import com.reavture.pojo.*;

public class UserRepo {
    static UserDao user = new UserDao();

    public List <User> findAllUser(){
        return user.findAll();
    }


    public User findUser(int id){
        return user.findById(id);
    }


    public User saveUser(User obj){
        return user.save(obj);
    }

    public User updateUser(User obj){
        return user.update(obj);
    }
}
