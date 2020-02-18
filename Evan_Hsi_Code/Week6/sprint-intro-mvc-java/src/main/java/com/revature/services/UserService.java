package com.revature.services;

import com.revature.entities.Credentials;
import com.revature.entities.User;
import com.revature.entities.UserRole;
import com.revature.exceptions.AuthenticationException;
import com.revature.exceptions.InvalidRequestException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {

    private Set<User> users = new HashSet<>();
    private int id = 4;

    {
        users.add(new User(1, "ehsi@gmail.com", "ehsi", "password", UserRole.ADMIN));
        users.add(new User(2, "ecdiao@gmail.com", "econraddiao", "password", UserRole.USER));
        users.add(new User(3, "jakewi@gmail.com", "jakewi", "password", UserRole.USER));
    }

    public Set<User> getAll() {
        return users;
    }

    public User register(User user) {
        user.setId(this.id++);
        users.add(user);
        return user;
    }

    public User getById(int id) {
        return users.stream().filter( u -> { return u.getId()==id;}).findFirst().orElseThrow(InvalidRequestException::new);
    }

    public User authenticate(Credentials creds) {

        if (creds == null || creds.getUsername() == null || creds.getPassword() == null) {
            throw new InvalidRequestException();
        }

        return users.stream().filter(u -> { return u.getUsername().equals(creds.getUsername()) && u.getPassword().equals(creds.getPassword()); } )
                .findFirst().orElseThrow(AuthenticationException::new);
    }
}
