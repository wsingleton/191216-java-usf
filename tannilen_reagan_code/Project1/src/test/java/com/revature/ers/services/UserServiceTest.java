package com.revature.ers.services;

import com.revature.ers.exceptions.AuthenticationException;
import com.revature.ers.exceptions.UnauthorizedRequestException;
import com.revature.ers.models.User;
import com.revature.ers.repos.UserRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserServiceTest {
    UserService sut;
    UserRepository userRepo=mock(UserRepository.class);
    Set<User> mockUsers=new HashSet<>();
    @Before
    public void setUp() {
        sut=new UserService(userRepo);
        User mgr = new User(1,"Manager","12345","Mandy","Ger","mandy.ger@example.com",1);
        User emp = new User(2,"Employee","09876","Emma","Ploye","emma.ploye@example.com",2);
        mockUsers.add(mgr);
        mockUsers.add(emp);
    }
    @After
    public void tearDown() {
        sut=null;
        mockUsers.removeAll(mockUsers);
    }
    @Test(expected = AuthenticationException.class)
    public void authenticateWithInvalidCredentials(){
        Optional<User> expected=Optional.empty();
        when(userRepo.findUserByCredentials(Mockito.anyString(),Mockito.anyString())).thenReturn(expected);
        sut.authenticate("Fake","NoGood");
    }
    @Test
    public void authenticateWithValidCredentials(){
        Optional<User> expected = mockUsers.stream().filter(u -> u.getUsername().equals("Employee")).findFirst();
        when(userRepo.findUserByCredentials(Mockito.anyString(),Mockito.anyString())).thenReturn(expected);
        User result=sut.authenticate("Manager","12345");
        assertEquals(expected.get(),result);
    }
    @Test(expected = UnauthorizedRequestException.class)
    public void findAllUsersAsEmployee(){
        sut.findAllUsers(2);
    }
    @Test
    public void findAllUsersAsManager(){
        when(userRepo.findAll()).thenReturn(mockUsers);
        Set<User> results=sut.findAllUsers(1);
        assertNotNull(results);
        assertEquals(2, results.size());
    }
}
