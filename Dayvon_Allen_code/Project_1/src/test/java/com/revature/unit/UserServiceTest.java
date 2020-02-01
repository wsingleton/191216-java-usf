package com.revature.unit;


import com.revature.ers.exceptions.AuthenticationException;
import com.revature.ers.exceptions.InvalidRequestException;
import com.revature.ers.exceptions.ResourcePersistenceException;
import com.revature.ers.models.User;
import com.revature.ers.repos.UserRepository;
import com.revature.ers.services.UserService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.ArrayList;
import java.util.Optional;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(PowerMockRunner.class)
@PowerMockIgnore({"org.mockito.*"})

public class UserServiceTest {
    UserService sut;
    UserRepository userRepo = mock(UserRepository.class);

    ArrayList<User> mockUsers = new ArrayList<>();

    @Before
    public void setUp() {
        sut = new UserService(userRepo);
        mockUsers.add(new User("","p4ssword","John","Smith","jsmith@gmail.com"));
        mockUsers.add(new User("jsmith","","John","Smith","jsmith@gmail.com"));
        mockUsers.add(new User("jsmith","p4ssw0rd","John","Smith","jsmith@gmail.com"));
    }

    @After
    public void tearDown() {
        sut = null;
        mockUsers.removeAll(mockUsers);
    }

    @Test(expected = InvalidRequestException.class)
    public void testAuthenticateMethodWithBadUsername() throws InvalidRequestException {
        User _expectedResult = mockUsers.get(0);
        sut.authenticate(_expectedResult.getUsername(), _expectedResult.getPassword());
    }

    @Test(expected = InvalidRequestException.class)
    public void testAuthenticateMethodWithBadPassword() throws InvalidRequestException {
        User _expectedResult = mockUsers.get(1);
        sut.authenticate(_expectedResult.getUsername(), _expectedResult.getPassword());
    }

    @Test(expected = AuthenticationException.class)
    public void testAuthenticateMethodWithUnknownUser() throws InvalidRequestException {
        String username = "test";
        String password = "password";
        Optional<User> _expectedResult = mockUsers.stream().filter(u -> u.getUsername().equals(username) && u.getPassword().equals(password)).findFirst();
        when(userRepo.findUserByCredentials(username, password)).thenReturn(_expectedResult);
        sut.authenticate(username,password);
    }

    @Test
    public void testAuthenticateMethodWithKnownUser() throws InvalidRequestException {
        String username = "jsmith";
        String password = "p4ssw0rd";
        Optional<User> _expectedResult = mockUsers.stream().filter(u -> u.getUsername().equals(username) && u.getPassword().equals(password)).findFirst();
        when(userRepo.findUserByCredentials(username, password)).thenReturn(_expectedResult);
        sut.authenticate(username,password);
    }

    @Test
    public void testIsValidMethodWithEmptyString() {
        User user = mockUsers.get(0);
        Assert.assertFalse(sut.isUserValid(user));
    }

    @Test
    public void testIsValidMethodWithEmptyPassword() {
        User user = mockUsers.get(1);
        Assert.assertFalse(sut.isUserValid(user));
    }

    @Test
    public void testIsValidMethodWithNullUser() {
        mockUsers.add(null);
        User user = mockUsers.get(3);
        Assert.assertFalse(sut.isUserValid(user));
    }

    @Test(expected = InvalidRequestException.class)
    public void testRegisterMethodWithInvalidRequest() throws InvalidRequestException, ResourcePersistenceException {
        User _expectedResult = mockUsers.get(0);
        sut.register(_expectedResult);
    }

    @Test(expected = ResourcePersistenceException.class)
    public void testRegisterMethodWithExistingUsername() throws InvalidRequestException, ResourcePersistenceException {
        String username = "jsmith";
        String password = "p4ssw0rd";
        Optional<User> _expectedResult = mockUsers.stream().filter(u -> u.getUsername().equals(username) && u.getPassword().equals(password)).findFirst();
        when(userRepo.findUserByUsername(username)).thenReturn(_expectedResult);
        sut.register(mockUsers.get(2));
    }
}
