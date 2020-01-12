package com.revature.services;

import com.revature.fauxbank.exceptions.InvalidRequestException;
import com.revature.fauxbank.models.Account;
import com.revature.fauxbank.models.AccountType;
import com.revature.fauxbank.models.User;
import com.revature.fauxbank.repos.AccountRepository;
import com.revature.fauxbank.repos.UserRepository;
import com.revature.fauxbank.services.UserService;
import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.HashMap;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    UserService sut;

    @InjectMocks
    UserRepository userRepo;
    @InjectMocks
    AccountRepository acctRepo;
    User user = new User();
    Account acct = new Account();
    Account currentAccount;

    @Before
    public void setup() {
        sut = new UserService(userRepo, acctRepo);
        MockitoAnnotations.initMocks(this);
        user = new User(1, "Blake", "Dunn", "testers", "p4ssword");
        acct = new Account(1, 100.0, AccountType.CHECKING);
    }

    @After
    public void tearDown() {
        sut = null;
        user = null;
        acct = null;
    }

//    @Test
//    public void testAuthenticateWithValidLogin() {
//        String username = "testers";
//        String password = "p4ssword";
//        Optional<User> _expectedUser = Optional.of(user);
//        Optional<Account> _expectedAcct = Optional.of(acct);
//        sut.authenticate(username, password);
//
//        when(userRepo.findUserByCredentials(Mockito.anyString(), Mockito.anyString()))
//                .thenReturn(_expectedUser);
//        acctRepo.findById(Mockito.anyInt()).ifPresent(acct -> currentAccount = acct);
//        when(_expectedAcct.isPresent()).thenReturn(true);
//        when(_expectedAcct.get()).thenReturn(acct);
//        assertEquals(_expectedUser.get(), user);
//    }

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
