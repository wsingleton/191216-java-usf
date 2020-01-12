package com.revature.services;

import com.revature.fauxbank.exceptions.InvalidRequestException;
import com.revature.fauxbank.models.Account;
import com.revature.fauxbank.models.User;
import com.revature.fauxbank.repos.AccountRepository;
import com.revature.fauxbank.repos.UserRepository;
import com.revature.fauxbank.services.UserService;
import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.HashMap;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @InjectMocks
    UserService sut;

    @Mock
    UserRepository userRepo;
    @Mock
    AccountRepository acctRepo;
    @Mock
    User user;
    @Spy
    Account currentAccount;
    @Spy
    User currentUser;
    @Captor
    ArgumentCaptor<String> username;
    @Captor
    ArgumentCaptor<String> password;
    @Captor
    ArgumentCaptor<Double> balance;
    @Captor
    ArgumentCaptor<Integer> id;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAuthenticateWithValidLogin() {
        user = new User(1, "Blake", "Dunn", "testers", "p4ssword");
        sut.authenticate("testers", "p4ssw0rd");

        verify(userRepo, times(1))
                .findUserByCredentials(username.capture(), password.capture());
        verify(acctRepo, times(1))
                .findById(user.getId());
    }

    @Test (expected = InvalidRequestException.class)
    public void testAuthenticateWithNullStrings() {
        sut.authenticate(null, null);
    }

    @Test (expected = InvalidRequestException.class)
    public void testAuthenticateWithEmptyString() {
        sut.authenticate("", "");
    }

    @Test (expected = InvalidRequestException.class)
    public void testAuthenticateWithNullUsername() {
        sut.authenticate(null, "assldfkjal");
    }

    @Test (expected = InvalidRequestException.class)
    public void testAuthenticateWithNullPassword() {
        sut.authenticate("Buhlakay", null);
    }

    @Test (expected = InvalidRequestException.class)
    public void testAuthenticateWithEmptyUsernameString() {
        sut.authenticate("", "buhlakay");
    }

    @Test (expected = InvalidRequestException.class)
    public void testAuthenticateWithEmptyPasswordString() {
        sut.authenticate("buhlakay", "");
    }

    @Test (expected = InvalidRequestException.class)
    public void testAuthenticateWithEmptyStringAndExtraSpaces() {
        sut.authenticate("       ", "buhlakay");
    }

    @Test (expected = InvalidRequestException.class)
    public void testAuthenticateWithEmptyPasswordAndExtraSpaces() {
        sut.authenticate("buhlakay", "          ");
    }

    @Test
    public void testAuthenticateWithValidUsernameAndPassword() {
        HashMap<Integer, User> userDb = new HashMap<>();
        userDb.put(1, new User("Blake", "Dunn", "Buhlakay", "Password"));


    }
}
