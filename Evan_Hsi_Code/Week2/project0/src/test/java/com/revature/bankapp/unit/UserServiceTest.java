package com.revature.bankapp.unit;

import com.revature.bankapp.BankDriver;
import com.revature.bankapp.appState;
import com.revature.bankapp.services.UserService;
import com.revature.bankapp.util.ConnectionFactory;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import com.revature.bankapp.services.UserService.*;
import com.revature.bankapp.exceptions.*;
import com.revature.bankapp.models.*;
import com.revature.bankapp.repositories.UserRepository;
import org.powermock.core.classloader.annotations.PowerMockIgnore;

import static junit.framework.TestCase.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.sql.Connection;
import java.util.HashSet;
import java.util.Set;

@RunWith(PowerMockRunner.class)
@PrepareForTest(BankDriver.class)
@PowerMockIgnore({"org.mockito.*"})

public class UserServiceTest {

    UserService sut;
    UserRepository userRepository = mock(UserRepository.class);
    BankDriver mockDriver = mock(BankDriver.class);
    appState mockState = mock(appState.class);
    ConnectionFactory mockConnFac = mock(ConnectionFactory.class);
    Connection mockConn = mock(Connection.class);

    Set<User> mockUsers = new HashSet<>();

    @Before
    public void setup() {

        sut = new UserService(userRepository);
        mockUsers.add(new User(1, "Evan", "Hsi", "ehsi", "p4ssw0rd", Role.ADMIN));
        mockUsers.add(new User(2, "first", "last", "username", "password", Role.BASIC_MEMBER));
        mockUsers.add(new User(3, "one", "two", "three", "four", Role.BASIC_MEMBER));
        mockUsers.add(new User(4, "a", "b", "c", "d", Role.BASIC_MEMBER));

    }

    @After
    public void teardown() {
        sut = null;
        mockUsers.removeAll(mockUsers);
    }

    @Test(expected = AuthenticationException.class)
    public void testAuthenticate() {
        mockStatic(BankDriver.class);
        when(mockDriver.app()).thenReturn(mockState);
        when(mockConnFac.getConnection()).thenReturn(mockConn);
        sut.authenticate("bad", "input");

    }

    @Test(expected = InvalidRequestException.class)
    public void testRegister1() {
        sut.register(new User("", "fine", "fine", "fine"));
    }

    @Test(expected = InvalidRequestException.class)
    public void testRegister2() {
        sut.register(new User("fine", "", "fine", "fine"));
    }

    @Test(expected = InvalidRequestException.class)
    public void testRegister3() {
        sut.register(new User("fine", "fine", null, "fine"));
    }

    @Test(expected = InvalidRequestException.class)
    public void testRegister4() {
        sut.register(null);
    }

    @Test
    public void testFindAll() {
        when(userRepository.findAll()).thenReturn(mockUsers);
        Set<User> result = sut.findAll();
        assertNotNull(result);
        assertEquals(4, result.size());
    }

    @Test
    public void testUpdateUser() {
        User user = new User(1, "John", "Jacobjingleheimerschmidt", "ehsi", "password", Role.ADMIN);
        when(userRepository.update(user)).thenReturn(true);
        boolean bool = sut.updateUser(user);
        assertTrue(bool);
    }

    @Test
    public void testUpdateUser2() {
        User user = new User(5, "John", "Jacobjingleheimerschmidt", "ehsi", "password", Role.ADMIN);
        when(userRepository.update(user)).thenReturn(false);
        boolean bool = sut.updateUser(user);
        assertFalse(bool);
    }

}
