package com.revature.ers.unit;


import com.revature.ers.exceptions.InvalidRequestException;
import com.revature.ers.exceptions.ResourcePersistenceException;
import com.revature.ers.models.Role;
import com.revature.ers.models.User;
import com.revature.ers.repos.UserRepository;
import com.revature.ers.services.UserService;
import com.revature.ers.util.ConnectionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ConnectionFactory.class})
@PowerMockIgnore({"org.mockito.*","javax.management.*","javax.script.*"})
public class UserServiceTest {

    UserService sut;
    UserRepository userRepo = mock(UserRepository.class);
    User mockUser = mock(User.class);

    @Before
    public void setup() {
        sut = new UserService(userRepo);
    }

    @After
    public void tearDown() {
        sut = null;
    }

    @Test
    public void testAuthenticateValidLogin() {
        String username = "buhlakay9";
        String password = "tester!";
        User expectedUser = new User(1, "Blake", "Dunn", "buhlakay9", "testers!", "buhlakay@buhlakify.com", Role.EMPLOYEE);

        when(userRepo.getUser(Mockito.anyString(), Mockito.anyString())).thenReturn(expectedUser);

        User actualResult = sut.authenticate(username, password);
        assertEquals(actualResult, expectedUser);
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
        User user = new User("buhlakay9", "testers!","Blak3", "Dunn",  "buhlakay@buhlakify.com");
        sut.register(user);
    }

    @Test (expected = InvalidRequestException.class)
    public void testRegisterWithInvalidLastName() {
        User user = new User("buhlakay9", "testers!","Blake", "3456",  "buhlakay@buhlakify.com");
        sut.register(user);
    }

    @Test
    public void testRegisterWithValidUser() {
        User user = new User("buhlakay9", "testers!","Blake", "Dunn",  "buhlakay@buhlakify.com");
        when(userRepo.findUserByUsername(Mockito.anyString())).thenReturn(Optional.empty());
        when(userRepo.save(Mockito.any())).thenReturn(mockUser);
        sut.register(user);
    }

    @Test(expected = ResourcePersistenceException.class)
    public void testRegisterWithUsernameTaken() {
        User user = new User("buhlakay9", "testers!","Blake", "Dunn",  "buhlakay@buhlakify.com");
        Optional<User> present = Optional.of(user);
        when(userRepo.findUserByUsername(anyString())).thenReturn(present);
        sut.register(user);
    }

    @Test
    public void testIsUserValidWithInvalidFirstName() {
        User user = new User("buhlakay9", "testers!","1234", "Dunn",  "buhlakay@buhlakify.com");
        Boolean actualResult = sut.isUserValid(user);
        assertEquals(false, actualResult );
    }

    @Test
    public void testIsUserValidWithInvalidLastName() {
        User user = new User("buhlakay9", "testers!","Blake", "1234",  "buhlakay@buhlakify.com");
        Boolean actualResult = sut.isUserValid(user);
        assertEquals(false, actualResult );
    }

    @Test
    public void testIsUserValidWithNullValue() {
        User user = new User("buhlakay9", "testers!","Blake", null,  "buhlakay@buhlakify.com");
        Boolean actualResult = sut.isUserValid(user);
        assertEquals(false, actualResult );
    }

    @Test
    public void testIsUserValidWithAnEmptyValue() {
        User user = new User("buhlakay9", "testers!","", "Dunn",  "buhlakay@buhlakify.com");
        Boolean actualResult = sut.isUserValid(user);
        assertEquals(false, actualResult );
    }

    @Test
    public void testIsUserValidWithValidUser() {
        User user = new User("buhlakay9", "testers!","Blake", "Dunn",  "buhlakay@buhlakify.com");
        Boolean actualResult = sut.isUserValid(user);
        assertEquals(true, actualResult );
    }

}
