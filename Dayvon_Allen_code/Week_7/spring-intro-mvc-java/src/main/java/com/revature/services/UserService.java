package com.revature.services;

import com.revature.dtos.Credentials;
import com.revature.entities.AppUser;
import com.revature.entities.UserRole;
import com.revature.exceptions.AuthenticationException;
import com.revature.exceptions.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {

    private Set<AppUser> users = new HashSet<>();
    private int id;

    {
        users.add(new AppUser(++id, "test@gmail.com", "wsingleton", "password", UserRole.ADMIN));
        users.add(new AppUser(++id, "test@gmail2.com", "winston", "password", UserRole.DEV));
        users.add(new AppUser(++id, "test@gmail3.com", "Harold", "password", UserRole.BASIC_USER));
    }
    public Set<AppUser> getAll() {
        return users;
    }

    public AppUser register(AppUser newUser){
        newUser.setId(++id);
        newUser.setRole(UserRole.BASIC_USER);
        users.add(newUser);
        return newUser;
    }

    public  AppUser getByid(int id) {
        return users.stream().filter(u -> u.getId() == id).findFirst().orElseThrow(RuntimeException::new);
    }

    public  AppUser authenicate(Credentials creds) {
        if(creds == null || creds.getUsername() == null || creds.getPassword() == null){
            throw new BadRequestException();
        }
         return users.stream().filter(u-> u.getUsername().equals(creds.getUsername()) && u.getPassword().equals(creds.getPassword()))
                .findFirst().orElseThrow(AuthenticationException::new);
    }
}
