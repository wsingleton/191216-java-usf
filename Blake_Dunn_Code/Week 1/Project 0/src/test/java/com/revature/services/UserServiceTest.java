package com.revature.services;

import com.revature.fauxbank.exceptions.InvalidRequestException;
import com.revature.fauxbank.models.User;
import com.revature.fauxbank.services.UserService;
import org.junit.*;
import org.junit.rules.ExpectedException;

import java.util.HashMap;

public class UserServiceTest {

    private UserService sut;


    @Before
    public void setUp() {
        sut = new UserService();
    }

    @After
    public void tearDown() {
        sut = null;
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
