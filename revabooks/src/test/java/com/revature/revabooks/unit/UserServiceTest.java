package com.revature.revabooks.unit;

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

import java.util.HashSet;
import java.util.Set;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserServiceTest {

    UserService sut;
    UserRepository userRepo = mock(UserRepository.class);
    AppState appState = mock(AppState.class);

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

    @Ignore("having trouble mocking the static AppState object")
    public void testGetAllUsersWhenCurrentUserIsNotAdmin() {
        when(appState.getCurrentSession()).thenReturn(mock(UserSession.class));
        when(appState.getCurrentSession().isAdminOrManager()).thenReturn(false);
        sut.getAllUsers();
    }

}
