package com.revature.services;

import com.revature.dto.Credentials;
import com.revature.entities.Role;
import com.revature.entities.User;
import com.revature.exceptions.AuthenticationException;
import com.revature.exceptions.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {
    private Set<User> users=new HashSet<>();
    private int id;

    {
        users.add(new User(++id, "ws@gmail.com", "wsingleton", "revature", Role.ADMIN));
        users.add(new User(++id, "bk@gmail.com", "bkruppa", "amazon", Role.DEV));
        users.add(new User(++id, "gb@gmail.com", "gbond", "revature", Role.BASIC));
    }
    public Set<User> getAll() {
        return users;
    }
    public User register(User u) {
        u.setId(++id);
        u.setRole(Role.BASIC);
        users.add(u);
        return u;
    }
    public User authenticate(Credentials creds) {
        if (creds==null || creds.getUsername()==null || creds.getPassword()==null) {
            throw new BadRequestException();
        }
        return users.stream().filter(u -> {
            return u.getUsername().equals(creds.getUsername()) && u.getPassword().equals(creds.getPassword());
        }).findFirst().orElseThrow(AuthenticationException::new);
    }
    public User getById(int id) {
        return users.stream().filter(u->u.getId()==id).findFirst().orElseThrow(RuntimeException::new);
    }
}
