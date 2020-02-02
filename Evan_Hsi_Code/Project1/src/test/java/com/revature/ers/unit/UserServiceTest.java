package com.revature.ers.unit;

import com.revature.ers.exceptions.AuthenticationException;
import com.revature.ers.exceptions.InvalidRequestException;
import com.revature.ers.exceptions.ResourceNotFoundException;
import com.revature.ers.models.Role;
import com.revature.ers.models.User;
import com.revature.ers.repositories.UserRepository;
import com.revature.ers.services.ReimbursementService;
import com.revature.ers.services.UserService;
import com.revature.ers.utils.ConnectionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import javax.ejb.LocalBean;
import java.sql.Connection;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.LogManager;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static org.mockito.Mockito.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest(ReimbursementService.class)
@PowerMockIgnore({"org.mockito.*"})

public class UserServiceTest {

    UserService sut;
    UserRepository userRepository = mock(UserRepository.class);
    ConnectionFactory mockConnFac = mock(ConnectionFactory.class);
    Connection mockConn = mock(Connection.class);
    User connUser = mock(User.class);

    Set<User> mockUsers = new HashSet<>();

    @Before
    public void setup() {
        sut = new UserService(userRepository);

        mockUsers.add(new User(1, "ehsi", "password", "Evan", "Hsi", "ehsi@gmail.com", Role.MANAGER));
        mockUsers.add(new User(2, "test1", "password", "test", "two", "two@gmail.com", Role.EMPLOYEE));
        mockUsers.add(new User(3, "test2", "password", "test", "three", "three@gmail.com", Role.EMPLOYEE));
        mockUsers.add(new User(4, "test3", "password", "test", "four", "four@gmail.com", Role.EMPLOYEE));
        mockUsers.add(new User(5, "test4", "password", "test", "five", "five@gmail.com", Role.LOCKED));

    }

    @After
    public void teardown(){
        sut = null;
        mockUsers.removeAll(mockUsers);
    }

    @Test(expected = AuthenticationException.class)
    public void testAuthenticate1() {
        sut.authenticate("fake", "user");
    }

    @Test(expected = InvalidRequestException.class)
    public void testAuthenticate2() {
        sut.authenticate("", "user");
    }

    @Test(expected = InvalidRequestException.class)
    public void testAuthenticate3() {
        sut.authenticate("fake", "");
    }

    @Test(expected = AuthenticationException.class)
    public void testAuthenticate4() {
        sut.authenticate("fak(e", "user");
    }

    @Test(expected = AuthenticationException.class)
    public void testAuthenticate5() {
        sut.authenticate("fake", "us'er");
    }

    @Test
    public void testGetAllUsers1() {
        when(connUser.getRole()).thenReturn(Role.MANAGER);
        when(userRepository.findAll(connUser)).thenReturn(mockUsers);
        Set<User> result = sut.getAllUsers(connUser);
        assertNotNull(result);
        assertEquals(5, result.size());
    }

    @Test(expected = ResourceNotFoundException.class)
    public void testGetAllUsers2() {
        when(connUser.getRole()).thenReturn(Role.MANAGER);
        when(userRepository.findAll(connUser)).thenReturn(new HashSet<User>());
        Set<User> result = sut.getAllUsers(connUser);
    }

    @Test(expected = Exception.class)
    public void confirmAccount1() {
        doThrow().when(userRepository).confirmAccount(6);
    }




    @Test
    public void placeholder() {
        assert(true);
    }

}
