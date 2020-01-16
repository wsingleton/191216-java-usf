package com.fauxnancials.services;

import com.fauxnancials.exceptions.AuthenticationException;
import com.fauxnancials.exceptions.InvalidRequestException;
import com.fauxnancials.exceptions.ResourcePersistenceException;
import com.fauxnancials.models.User;
import com.fauxnancials.models.UserType;
import com.fauxnancials.repos.UserRepository;
import org.junit.*;
import org.mockito.Mockito;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class UserServiceTests {
    UserService sut;
    UserRepository userRepo= Mockito.mock(UserRepository.class);

    Set<User> mockUsers = new HashSet<>();

    @Before
    public void setUp() {
        sut = new UserService(userRepo);
        mockUsers.add(new User(1,"csagan", 38248421, "Carl", "Sagan", UserType.USER));
        mockUsers.add(new User(2, "dinomom", -399728007, "Mary", "Anning", UserType.USER));
    }

    @After
    public void tearDown() {
        sut = null;
        mockUsers.removeAll(mockUsers);
    }

    @Test(expected = InvalidRequestException.class)
    public void testAuthenticateWithANullUsername() {
        String s=null;
        int x="p4ssw0rd".hashCode();
        sut.authenticate(s, x);
    }
    @Test(expected = InvalidRequestException.class)
    public void testAuthenticateWithAnEmptyUsername() {
        String s="";
        int x="p4ssw0rd".hashCode();
        sut.authenticate(s, x);
    }
    @Test(expected = InvalidRequestException.class)
    public void testAuthenticateWithAnEmptyPassword() {
        String s="Test";
        int x=0;
        sut.authenticate(s, x);
    }
    @Test(expected = AuthenticationException.class)
    public void testAuthenticateWithInvalidNameOrPW() {
        String s="dinomom";
        int x=38248421;
        sut.authenticate(s, x);
    }
    @Test
    public void testValidateUserFieldsNullUser() {
        User user=null;
        boolean result=sut.validateUserFields(user);
        assertEquals(false, result);
    }
    @Test
    public void testValidateUserGivenNameInvalid() {
        User user=new User("test", 5, "", "Doe");
        boolean result=sut.validateUserFields(user);
        assertEquals(false, result);
    }
    @Test
    public void testValidateUserFamilyNameInvalid() {
        User user=new User("test", 5, "Jordan", null);
        boolean result=sut.validateUserFields(user);
        assertEquals(false, result);
    }
    @Test
    public void testValidateUserUsernameInvalid() {
        User user=new User("", 5, "Jordan", "Doe");
        boolean result=sut.validateUserFields(user);
        assertEquals(false, result);
    }
    @Test
    public void testValidateUserPassInvalid() {
        User user=new User("test", 0, "Jordan", "Doe");
        boolean result=sut.validateUserFields(user);
        assertEquals(false, result);
    }
    @Test
    public void testValidateUserAllFieldsValid() {
        User user=new User("test", 5, "Jordan", "Doe");
        boolean result=sut.validateUserFields(user);
        assertEquals(true, result);
    }
}
