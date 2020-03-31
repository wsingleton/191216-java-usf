package com.revature.services;

import com.revature.dtos.Credentials;
import com.revature.entities.AppUser;
import com.revature.entities.UserRole;
import com.revature.exceptions.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {

    private Set<AppUser> users = new HashSet<>();
    private int id;

    {
        users.add(new AppUser(1, "wz@gmail.com", "wsingleton", "revature", UserRole.ADMIN));
        users.add(new AppUser(2, "kl@gmail.com", "kloggins", "tonight", UserRole.DEV));
        users.add(new AppUser(3, "rs@gmail.com", "rspectra", "password", UserRole.BASIC_USER));
    }

    public Set<AppUser> getAll(){
        return users;
    }

    public AppUser getById(int id){
        return users.stream().filter(u -> u.getId() == id).findFirst().orElseThrow(RuntimeException::new);
    }

    public AppUser register(AppUser newUser){
        newUser.setId(++id);
        newUser.setRole(UserRole.BASIC_USER);
        users.add(newUser);
        return newUser;
    }

    public AppUser authenticate(Credentials creds){

        if(creds == null || creds.getUsername() == null || creds.getPassword() == null){
            throw new BadRequestException();
        }

        return users.stream().filter(u -> {
            return u.getUsername().equals(creds.getUsername()) && u.getPassword().equals(creds.getPassword());
        }).findFirst().orElseThrow(RuntimeException::new);
    }
}
