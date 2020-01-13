package com.revature.revabooks.unit;

import com.revature.revabooks.AppDriver;
import com.revature.revabooks.exceptions.AuthorizationException;
import com.revature.revabooks.models.*;
import com.revature.revabooks.repos.UserRepository;
import com.revature.revabooks.services.BookService;
import com.revature.revabooks.services.UserService;
import com.revature.revabooks.util.AppState;
import com.revature.revabooks.util.UserSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
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
@PrepareForTest(AppDriver.class)
@PowerMockIgnore({"org.mockito.*"})
public class UserServiceTest {

    UserService sut;
    UserRepository userRepo = mock(UserRepository.class);
    AppDriver mockDriver = mock(AppDriver.class);
    AppState mockState = mock(AppState.class);
    UserSession mockSession = mock(UserSession.class);

    Set<User> mockUsers = new HashSet<>();

    @Before
    public void setUp() {

        sut = new UserService(userRepo);
        mockUsers.add(new User(1, "admin", "secret", "Adam", "En", Role.ADMIN));
        mockUsers.add(new User(2, "manager", "mngr", "Manny", "Gerr", Role.MANAGER));
        mockUsers.add(new User(3, "alice", "p4ssw0rd", "Alice", "Test", Role.PREMIUM_MEMBER));
        mockUsers.add(new User(4, "bob", "test", "Bob", "Test", Role.BASIC_MEMBER));

    }

    @After
    public void tearDown() {
        sut = null;
        mockUsers.removeAll(mockUsers);
    }

    @Test(expected = AuthorizationException.class)
    public void testGetAllUsersWhenCurrentUserIsNotAdmin() {
        mockStatic(AppDriver.class);
        when(mockDriver.app()).thenReturn(mockState);
        when(mockState.getCurrentSession()).thenReturn(mockSession);
        when(mockSession.isAdminOrManager()).thenReturn(false);
        sut.getAllUsers();
    }

}
