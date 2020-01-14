package com.revature.fauxbankextended.unit;

import com.revature.fauxbankextended.BankDriver;
import com.revature.fauxbankextended.exceptions.InvalidRequestException;
import com.revature.fauxbankextended.exceptions.ResourcePersistenceException;
import com.revature.fauxbankextended.models.Account;
import com.revature.fauxbankextended.models.AccountType;
import com.revature.fauxbankextended.models.User;
import com.revature.fauxbankextended.repos.AccountRepository;
import com.revature.fauxbankextended.repos.UserRepository;
import com.revature.fauxbankextended.services.UserService;
import com.revature.fauxbankextended.util.AppState;
import com.revature.fauxbankextended.util.ConnectionFactory;
import com.revature.fauxbankextended.util.UserSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.sql.Connection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.powermock.api.mockito.PowerMockito.mockStatic;

@RunWith(PowerMockRunner.class)
@PrepareForTest({BankDriver.class, ConnectionFactory.class})
@PowerMockIgnore({"org.mockito.*"})
public class UserServiceTest {

    UserService sut;
    UserRepository userRepo = mock(UserRepository.class);
    AccountRepository acctRepo = mock(AccountRepository.class);
    BankDriver mockDriver = mock(BankDriver.class);
    AppState mockState = mock(AppState.class);
    UserSession mockSession = mock(UserSession.class);
    ConnectionFactory mockConnFactory = mock(ConnectionFactory.class);
    Connection mockConn = mock(Connection.class);
    User mockUser = mock(User.class);

    Set<User> mockUsers = new HashSet<>();

    @Before
    public void setup() {
        sut = new UserService(userRepo, acctRepo);
        mockUsers.add(new User(1, "Blake", "Dunn", "buhlakay9", "testers!"));
    }

    @After
    public void tearDown() {
        sut = null;
        mockUsers.removeAll(mockUsers);
    }

    @Test
    public void testAuthenticateValidLogin() {
        User expectedUser = new User(1, "Blake", "Dunn", "buhlakay9", "testers!");
        Account expectedAcct = new Account(1, 500.0, AccountType.CHECKING);
        mockStatic(BankDriver.class);
        mockStatic(ConnectionFactory.class);
        when(mockDriver.app()).thenReturn(mockState);
        when(mockState.getCurrentSession()).thenReturn(mockSession);
        when(mockConnFactory.getInstance()).thenReturn(mockConnFactory);
        when(mockConnFactory.getConnection()).thenReturn(mockConn);
        when(userRepo.getUser(Mockito.anyString(), Mockito.anyString())).thenReturn(expectedUser);
        when(acctRepo.getAccount(Mockito.any())).thenReturn(expectedAcct);

        sut.authenticate(expectedUser.getUserName(), expectedUser.getPassword());
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

    @Test (expected = InvalidRequestException.class)
    public void testRegisterWithInvalidFirstName() {
        User user = new User("Blak3", "Dunn", "buhlakay9", "testers!");
        sut.register(user);
    }

    @Test (expected = InvalidRequestException.class)
    public void testRegisterWithInvalidLasttName() {
        User user = new User("Blake", "3456", "buhlakay9", "testers!");
        sut.register(user);
    }

    @Test (expected = InvalidRequestException.class)
    public void testRegisterWithInvalidUsername() {
        User user = new User("Blake", "Dunn", "buhlak", "testers!");
        sut.register(user);
    }

    @Test (expected = InvalidRequestException.class)
    public void testRegisterWithInvalidPassword() {
        User user = new User("Blak3", "Dunn", "buhlakay9", "testers");
        sut.register(user);
    }

    @Test
    public void testRegisterWithValidUser() {
        User user = new User("Blake", "Dunn", "buhlakay9", "testers!");
        when(userRepo.findUserByUserName(Mockito.anyString())).thenReturn(Optional.empty());
        when(userRepo.save(Mockito.any())).thenReturn(mockUser);
        sut.register(user);
    }

    @Test
    public void testSetNewAccountToSetAccountToChecking() {
        String type = "1";
        User user = new User(1, "Blake", "Dunn", "buhlakay9", "testers!");
        Account expectedAcct = new Account(1, 0.0, AccountType.CHECKING);
        mockStatic(BankDriver.class);
        mockStatic(ConnectionFactory.class);
        when(mockDriver.app()).thenReturn(mockState);
        when(mockState.getCurrentSession()).thenReturn(mockSession);
        when(mockConnFactory.getInstance()).thenReturn(mockConnFactory);
        when(mockConnFactory.getConnection()).thenReturn(mockConn);
        when(acctRepo.save(Mockito.any())).thenReturn(expectedAcct);
        when(userRepo.updateCompositeKey(Mockito.any(), Mockito.any())).thenReturn(true);
        sut.setNewAccount(user, type);
    }

    @Test
    public void testSetNewAccountToSetAccountToSavings() {
        String type = "2";
        User user = new User(1, "Blake", "Dunn", "buhlakay9", "testers!");
        Account expectedAcct = new Account(1, 0.0, AccountType.SAVINGS);
        mockStatic(BankDriver.class);
        mockStatic(ConnectionFactory.class);
        when(mockDriver.app()).thenReturn(mockState);
        when(mockState.getCurrentSession()).thenReturn(mockSession);
        when(mockConnFactory.getInstance()).thenReturn(mockConnFactory);
        when(mockConnFactory.getConnection()).thenReturn(mockConn);
        when(acctRepo.save(Mockito.any())).thenReturn(expectedAcct);
        when(userRepo.updateCompositeKey(Mockito.any(), Mockito.any())).thenReturn(true);
        sut.setNewAccount(user, type);
    }

    @Test (expected = ResourcePersistenceException.class)
    public void testRegisterWithUsernameTaken() {
        User user = new User("Blake", "Dunn", "buhlakay9", "testers!");
        when(userRepo.findUserByUserName(Mockito.anyString()))
                .thenThrow(new ResourcePersistenceException("Username is already in use!"));
        sut.register(user);
    }

    @Test
    public void testIsUserValidWithInvalidFirstName() {
        User user = new User("1234", "Dunn", "buhlakay9", "testers!");
        Boolean actualResult = sut.isUserValid(user);
        assertEquals(false, actualResult );
    }

    @Test
    public void testIsUserValidWithInvalidLastName() {
        User user = new User("Blake", "1234", "buhlakay9", "testers!");
        Boolean actualResult = sut.isUserValid(user);
        assertEquals(false, actualResult );
    }

    @Test
    public void testIsUserValidWithInvalidUsername() {
        User user = new User("Blake", "Dunn", "buhla", "testers!");
        Boolean actualResult = sut.isUserValid(user);
        assertEquals(false, actualResult );
    }

    @Test
    public void testIsUserValidWithInvalidPassword() {
        User user = new User("Blake", "Dunn", "buhlakay9", "testers");
        Boolean actualResult = sut.isUserValid(user);
        assertEquals(false, actualResult );
    }

    @Test
    public void testIsUserValidWithNullValue() {
        User user = new User("Blake", null, "buhlakay9", "testers!");
        Boolean actualResult = sut.isUserValid(user);
        assertEquals(false, actualResult );
    }

    @Test
    public void testIsUserValidWithAnEmptyValue() {
        User user = new User("", "Dunn", "buhlakay9", "testers!");
        Boolean actualResult = sut.isUserValid(user);
        assertEquals(false, actualResult );
    }

    @Test
    public void testIsUserValidWithValidUser() {
        User user = new User("Blake", "Dunn", "buhlakay9", "testers!");
        Boolean actualResult = sut.isUserValid(user);
        assertEquals(true, actualResult );
    }
}

