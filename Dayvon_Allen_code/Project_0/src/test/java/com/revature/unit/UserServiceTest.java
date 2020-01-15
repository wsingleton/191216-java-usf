package com.revature.unit;

import com.revature.BankDriver;
import com.revature.exceptions.AuthenticationException;
import com.revature.exceptions.InvalidRequestException;
import com.revature.exceptions.ResourcePersistentException;
import com.revature.models.User;
import com.revature.repos.UserRepository;
import com.revature.services.UserService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.ArrayList;
import java.util.Optional;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.mockStatic;

@RunWith(PowerMockRunner.class)
@PrepareForTest(BankDriver.class)
@PowerMockIgnore({"org.mockito.*"})

public class UserServiceTest {
    UserService sut;
    UserRepository userRepo = mock(UserRepository.class);
    User mockUser = mock(User.class);

    ArrayList<User> mockUsers = new ArrayList<>();

    @Before
    public void setUp() {
        sut = new UserService(userRepo);
        mockUsers.add(new User("testUser", "testpassword", "testUser".hashCode()));
        mockUsers.add(new User("", "password", 303094949));
        mockUsers.add(new User("test_user", "", 303094949));
        mockUsers.add(new User("testUser", "testpassword", 1010101010));
        mockUsers.add(new User("testUser", "testpassword", 1010101010));

    }

    @After
    public void tearDown() {
        sut = null;
        mockUsers.removeAll(mockUsers);
    }

    @Test(expected = InvalidRequestException.class)
    public void testAuthenticateMethodWithBadUsername() {
        User _expectedResult = mockUsers.get(1);
        sut.authenticate(_expectedResult.getUsername(), _expectedResult.getPassword());
    }

    @Test(expected = InvalidRequestException.class)
    public void testAuthenticateMethodWithBadPassword() {
        User _expectedResult = mockUsers.get(2);
        sut.authenticate(_expectedResult.getUsername(), _expectedResult.getPassword());
    }

    @Test(expected = AuthenticationException.class)
    public void testAuthenticateMethodWithUnknownUser() {
        String username = "fake";
        String password = "testpassword";
        Optional<User> _expectedResult = mockUsers.stream().filter(u -> u.getUsername().equals(username) && u.getPassword().equals(password)).findFirst();
        mockStatic(BankDriver.class);
        when(BankDriver.user()).thenReturn(mockUser);
        when(userRepo.findUserByCredentials(username, password)).thenReturn(_expectedResult);
        sut.authenticate(username,password);
    }

    @Test
    public void testAuthenticateMethodWithKnownUser() {
        String username = "testUser";
        String password = "testpassword";
        Optional<User> _expectedResult = mockUsers.stream().filter(u -> u.getUsername().equals(username) && u.getPassword().equals(password)).findFirst();
        mockStatic(BankDriver.class);
        when(BankDriver.user()).thenReturn(mockUser);
        when(userRepo.findUserByCredentials(username, password)).thenReturn(_expectedResult);
        sut.authenticate(username,password);
    }

    @Test
    public void testIsValidMethodWithEmptyString() {
        User user = mockUsers.get(1);
        Assert.assertFalse(sut.isUserValidate(user));
    }

    @Test
    public void testIsValidMethodWithEmptyPassword() {
        User user = mockUsers.get(2);
        Assert.assertFalse(sut.isUserValidate(user));
    }

    @Test
    public void testIsValidMethodWithNullUser() {
        mockUsers.add(null);
        User user = mockUsers.get(5);
        Assert.assertFalse(sut.isUserValidate(user));
    }

    @Test(expected = InvalidRequestException.class)
    public void testRegisterMethodWithInvalidRequest() {
        User _expectedResult = mockUsers.get(1);
        sut.register(_expectedResult);
    }

    @Test(expected = ResourcePersistentException.class)
    public void testRegisterMethodWithExistingUsername() {
        String username = "testUser";
        String password = "testpassword";
        Optional<User> _expectedResult = mockUsers.stream().filter(u -> u.getUsername().equals(username) && u.getPassword().equals(password)).findFirst();
        mockStatic(BankDriver.class);
        when(BankDriver.user()).thenReturn(mockUser);
        when(userRepo.findUserByUsername(username)).thenReturn(_expectedResult);
        sut.register(mockUsers.get(0));
    }
}
