package com.revature.mockBank.services;

import com.revature.mockbank.AppDriver;
import com.revature.mockbank.exceptions.AuthorizationException;
import com.revature.mockbank.exceptions.ResourceNotFoundException;
import com.revature.mockbank.services.UserService;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import com.revature.mockbank.models.*;
import com.revature.mockbank.repositories.UserRepo;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.mockStatic;

@RunWith(PowerMockRunner.class)
@PrepareForTest(AppDriver.class)
@PowerMockIgnore({"org.mockito.*"})

public class UserServiceTest {
        UserService sut;

        UserRepo userRepo = mock(UserRepo.class);
        UserService userService = mock(UserService.class);
        User testUser = new User();

        @Before
        public void setUp (){
            sut = new UserService(userRepo);
            testUser.setId(1);
            testUser.setFirstName("Brandy");
            testUser.setLastName("Departed");
            testUser.setUsername("bdep");
            testUser.setPassword("brandypass");
            testUser.setRole(Role.ADMIN);
        }

        @After
    public void tearDown(){
            sut = null;
        }

        @Test
    public void testIsValidMethodToConfirmIfTheUserMeetsTheMinimumRequirements(){
            when(userService.isUserValid(testUser)).thenReturn(true);
            sut.isUserValid(testUser);
        }

        @Test(expected = ResourceNotFoundException.class)
    public void testFindAllUsersMethodWhenUserSetReturnedIsEmpty(){
            when(userService.findAllUsers("Admin").isEmpty()).thenThrow(ResourceNotFoundException.class);
            sut.findAllUsers("Admin");
        }

    @Test(expected = AuthorizationException.class)
    public void testFindAllUsersMethodWhenCurrentUserRoleIsNotAdmin(){
            mockStatic(AppDriver.class);
        //when(AppDriver.currentUser == null).thenReturn(false);
        when(userService.findAllUsers("Customer")).thenThrow(AuthorizationException.class);
        sut.findAllUsers("Customer");
    }
}
