package com.revature.mockERS;

import com.revature.mockERS.exceptions.InvalidRequestException;
import com.revature.mockERS.models.ERS_User_Roles;
import com.revature.mockERS.models.ERS_Users;
import com.revature.mockERS.repositories.UserRepository;

import com.revature.mockERS.services.UserService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Spy;

import java.util.Optional;

import static org.mockito.Mockito.*;

public class UserServiceTest {
    private UserService sut;
    private UserService sut1 = mock(UserService.class);
    private UserRepository ur = mock(UserRepository.class);
    private ERS_Users user = mock(ERS_Users.class);
    @Spy
    private ERS_Users user1 = new ERS_Users("spiteria","password","Andrew", "Spiteri", "spiteria@gmail.com");


    @Before
    public void setUp(){
        sut = new UserService(ur);
    }

    @After
    public void tearDown(){
        sut = null;
    }

    @Test
    public void testLogin(){
        when(ur.findByCredentials("username", "password")).thenReturn(Optional.of(user));
        ERS_Users result = sut.login("username", "password");
        Assert.assertEquals(user, result);
    }


    //TODO Ask Wezley about testRegister throwing InvalidRequestException
    @Test(expected = InvalidRequestException.class)
    public void testRegister(){
        doReturn(true).when(sut1).isUserValid(user1);
        when(ur.findByUsername(user.getErsUsername())).thenReturn(Optional.of(user));
        when(ur.addUser(user)).thenReturn(true);
        Boolean success = sut.register(user);
        Assert.assertEquals(success,true);
    }

    @Test
    public void testUserValid(){
        Boolean outcome = sut.isUserValid(user1);
        Assert.assertEquals(true, outcome);
    }
}
