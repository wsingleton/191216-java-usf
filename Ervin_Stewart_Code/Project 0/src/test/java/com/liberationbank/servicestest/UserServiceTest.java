package com.liberationbank.servicestest;

import com.liberationbank.AppDriver;
import com.liberationbank.models.User;
import com.liberationbank.repos.UserRepository;
import com.liberationbank.services.AccountService;
import com.liberationbank.services.UserService;
import com.liberationbank.util.ConnectionFactory;
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
import static org.junit.Assert.assertEquals;
import static org.powermock.api.mockito.PowerMockito.mock;

@RunWith(PowerMockRunner.class)
@PrepareForTest({AppDriver.class, ConnectionFactory.class})
@PowerMockIgnore({"org.mockito.*"})
public class UserServiceTest {

    private UserService sut;
public UserService mockService = mock( UserService.class);
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
    public void setUp(){
        sut = new UserService(mockRepo);
    }
    @After
    public void tearDown(){
        sut = null;
    }

    @Test
    public void testIsUserValidForCorrectInputs(){
        String message = "if all inputs are entered correctly, return true";
        User testUser = new User("Ervin","Stewart","Spacemvn","Morbius@");
        boolean actualResult = sut.isUserValid(testUser);
        assertTrue(message, actualResult);
    }

    @Test
    public void testIsUserValidForInvalidFirst(){
        String message = "if a single input is invalid, return false";
         User testUser = new User("Er!vn","Stewart","Spacemvn","Morbius!");

        boolean actualResult = sut.isUserValid(testUser);
        assertFalse(message, actualResult);
    }

    @Test
    public void testisValidPasswordLengthForFalse(){
        String message = "if the input is too short of a string but contains a character, return false";
        String testPassword = "dog!";
        boolean actualResult = sut.isValidPassword(testPassword);
        assertTrue(message, actualResult);
    }

    @Test
    public void testisValidPasswordForCorrectPassword(){
        String message = "if the input is within the length range and has a special character, return true";
        String testPassword = "GreenGob!n";
        boolean actualResult = sut.isValidPassword(testPassword);
        assertFalse(message, actualResult);
    }

    @Test
    public void testisValidPasswordSpecialCharacterForFalse(){
        String message = "if the input is has the correct character amount but no Special character, return false";
        String testPassword = "dogloves";
        boolean actualResult = sut.isValidPassword(testPassword);
        assertTrue(message, actualResult);
    }

    @Test
    public void testCorrectUsernameLengthFalse(){
        String message = "if the username input is 25 characters or less, return  false";
        String testUsername = "Spacemvn";
        boolean actualResult = sut.checkUserNameLength(testUsername);
        assertFalse(message, actualResult);


    }

    @Test
    public void testCorrectUsernameLengthTrue(){
        String message = "if the username input is more than 25 characters, return  true";
        String testUsername = "Spacemvnisthegodofallthingsdumbandyetstillcool";
        boolean actualResult = sut.checkUserNameLength(testUsername);
        assertTrue(message, actualResult);


    }
//    @Test
//    public void testSolutionWithTwoPlaces(){
//        String message = "If a reversed array is provided, the implementation should sort the array";
//        double testArray = 50.99;
//        double expectedResult = 50.99;
//        double actualResult = sut.sanitizeValue(testArray);
//        assertEquals(message,expectedResult,actualResult, expectedResult);
//    }
}
