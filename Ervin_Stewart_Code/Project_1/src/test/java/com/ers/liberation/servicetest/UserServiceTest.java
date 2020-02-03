package com.ers.liberation.servicetest;

import com.ers.liberation.models.User;
import com.ers.liberation.repos.UserRepository;
import com.ers.liberation.services.UserService;
import com.ers.liberation.util.ConnectionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.*;
import static org.powermock.api.mockito.PowerMockito.mock;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ ConnectionFactory.class})
@PowerMockIgnore({"org.mockito.*"})
public class UserServiceTest {

    private UserService sut;
    public UserService mockService = mock(UserService.class);
    public UserRepository mockRepo = mock(UserRepository.class);
    /*
    JUnit rules is a component that intercepts test method calls and allows us to do something before a test method has
     run - typically adding additional constraints to the test case.
     */
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Rule
    public Timeout globalTimeout = Timeout.seconds(5);

    @Before
    public void setUp() {
        sut = new UserService(mockRepo);
    }

    @After
    public void tearDown() {
        sut = null;
    }

    @Test
    public void testIsUserValidForCorrectInputs() {
        String message = "if all inputs are entered correctly, return true";
        User testUser = new User("Ervin", "Stewart", "Spacemvn", "Morbius@", "ervin.stewart@Liberation.com");
        boolean actualResult = sut.isUserValid(testUser);
        assertTrue(message, actualResult);
    }

    @Test
    public void testIsUserValidForInvalidFN() {
        String message = "if a single input is invalid, return false";
        User testUser = new User("Er!vn", "Stewart", "Spacemvn", "Morbius!", "ervin.stewart@Liberation.com");

        boolean actualResult = sut.isUserValid(testUser);
        assertFalse(message, actualResult);
    }

    @Test
    public void testisValidPasswordLengthForFalse() {
        String message = "if the input is too short of a string but contains a character, return false";
        String testPassword = "dog!";
        boolean actualResult = sut.isValidPassword(testPassword);
        assertTrue(message, actualResult);
    }

    @Test
    public void testisValidPasswordForCorrectPassword() {
        String message = "if the input is within the length range and has a special character, return true";
        String testPassword = "GreenGob!n";
        boolean actualResult = sut.isValidPassword(testPassword);
        assertFalse(message, actualResult);
    }

    @Test
    public void testisValidPasswordSpecialCharacterForFalse() {
        String message = "if the input is has the correct character amount but no Special character, return false";
        String testPassword = "dogloves";
        boolean actualResult = sut.isValidPassword(testPassword);
        assertTrue(message, actualResult);
    }

    @Test
    public void testCorrectUsernameLengthFalse() {
        String message = "if the username input is 50 characters or less, return  false";
        String testUsername = "Spacemvn";
        boolean actualResult = sut.checkUserNameLength(testUsername);
        assertFalse(message, actualResult);


    }

    @Test
    public void testCorrectUsernameLengthTrue() {
        String message = "if the username input is more than 50 characters, return  true";
        String testUsername = "SpacemvnisthegodofallthingsdumbandyetstillcooldogbroireallySpacemvnisthegodofallthingsdumbandyetstillcooldogbroireally";
        boolean actualResult = sut.checkUserNameLength(testUsername);
        assertTrue(message, actualResult);


    }


    @Test
    public void testInvalidNewAdminAccess(){
        String message = "if the Access code is incorrect the value 0 will be returned dening the user authorization for " +
                "more functionality within our app";
        Integer testCode = 555888;
        Integer expectedResult = 0;
        Integer actualResult = sut.adminValidation(testCode);
        assertEquals(message,expectedResult, actualResult);


    }


    @Test
    public void testNewAdminAccess(){
        String message = "if the Access code is incorrect the value 0 will be returned dening the user authorization for " +
                "more functionality within our app";
        Integer testCode = 336879;
        Integer expectedResult = 2;
        Integer actualResult = sut.adminValidation(testCode);
        assertEquals(message,expectedResult, actualResult);


    }

    @Test
    public void testNewCFOAccess(){
        String message = "if the Access code is correct for the cfo the value 3 will be returned" +
                " granting the user authorization for more functionality within our app";
        Integer testCode = 547896;
        Integer expectedResult = 3;
        Integer actualResult = sut.adminValidation(testCode);
        assertEquals(message,expectedResult, actualResult);


    }

    @Test
    public void testInvalidEmail(){
        String message = "Checks the String for whatever@whatever.whatever if false then returns true";
        String email = "ervin.stewart@";
        boolean actualResult = sut.checkEmail(email);
        assertTrue(message, actualResult);
    }

    @Test
    public void testValidEmail(){
        String message ="Checks the String for whatever@whatever.whatever if true then returns false";
        String email = "ervin.stewart@Liberation.com";
        boolean actualResult = sut.checkEmail(email);
        assertFalse(message,actualResult);
    }

    @Test
    public void testValidFLName(){
        String message = "If First name or last name does not contain a special character or is empty/null return false";
        String name = "Ervin";
        boolean actualResult = sut.checkFLNameLength(name);
        assertFalse(message, actualResult);
    }

    @Test
    public void testInvalidFLName(){
        String message ="If First name or last name contains a special character or is empty/null return true";
        String name = "Dog!man";
        boolean actualResult = sut.checkFLNameLength(name);
        assertTrue(message,actualResult);
    }

}

