package services;

import com.revature.MockBankDriver;
import com.revature.models.Role;
import com.revature.models.User;
import com.revature.repositories.UserRepository;
import com.revature.services.AccountService;
import com.revature.services.UserService;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import static com.revature.services.UserService.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(PowerMockRunner.class)
public class UserServiceTest {

    UserService sut;
    UserRepository ur = mock(UserRepository.class);
    MockBankDriver mockDriver = mock(MockBankDriver.class);

    User user1 = new User("Roberto", "Gonzalez", "rGonzalez","password", Role.MEMBER);
    User user2 = new User("Roberta", "Consuelo", "rConsuelo","password", Role.MEMBER);
    Set<User> users = new HashSet<>();

    @Before
    public void setUp(){
        sut = new UserService(ur);
        user1.setId(Objects.hashCode(user1.getUserName()));
        user1.setTu(800);
        user1.setExp(800);
        user2.setId(Objects.hashCode(user2.getUserName()));
        user2.setTu(800);
        user2.setExp(800);
        users.add(user1);
        users.add(user2);
    }

    @After
    public void tearDown(){
        sut = null;
    }

    @Test
    public void testLogin(){
        when(ur.save(users, 1)).thenReturn(true);
        //when(AccountService.registerAccount(users.))
        sut.login("spiteria","password");
    }

    @Test
    @PrepareForTest({AccountService.class})
    public void testRegistration(){

       // Boolean bool = registerUser(false, );
    }
}
