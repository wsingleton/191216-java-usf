package com.revature.unit;

import com.revature.BankDriver;
import com.revature.exceptions.InvalidRequestException;
import com.revature.models.User;
import com.revature.repos.UserRepository;
import com.revature.services.UserService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.mockStatic;

@RunWith(PowerMockRunner.class)
@PrepareForTest(BankDriver.class)
@PowerMockIgnore({"org.mockito.*"})
public class UserServiceTest {
    UserService sut;
    UserRepository userRepo = mock(UserRepository.class);

    Set<User> mockUsers = new HashSet<>();

    @Before
    public void setUp() {
        sut = new UserService(userRepo);
        mockUsers.add(new User("testUser", "testpassword", 1010101010));
    }

    @After
    public void tearDown() {
        sut = null;
        mockUsers.removeAll(mockUsers);
    }

    @Test(expected = InvalidRequestException.class)
    public void testGetAllUsersWhenCurrentUserIsNotAdmin() {
        mockStatic(BankDriver.class);
//        when(mockDriver.app()).thenReturn(mockState);
//        when(mockState.getCurrentSession()).thenReturn(mockSession);
//        when(mockSession.isAdminOrManager()).thenReturn(false);
//        sut.getAllUsers();
    }
}
