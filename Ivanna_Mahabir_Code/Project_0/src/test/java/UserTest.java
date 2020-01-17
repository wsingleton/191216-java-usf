import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.revature.bank.AppDriver;
import com.revature.bank.exceptions.InvalidRequestException;
import com.revature.bank.models.User;
import com.revature.bank.repos.UserRepository;
import com.revature.bank.services.UserService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.ArrayList;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.mockStatic;

@RunWith(PowerMockRunner.class)
@PrepareForTest(AppDriver.class)
@PowerMockIgnore({"org.mockito.*"})

public class UserTest {

    UserService sut;
    UserRepository userRepository;
    User user = mock(User.class);

    ArrayList<User> mUser = new ArrayList<>();

    @Before
    public void init(){
        sut = new UserService(userRepository);
        mUser.add(new User(1, "Tarja","Turu", "User3", "Pass3"));
        mUser.add(new User(2, "","", "", ""));
        mUser.add(new User(3, "","Turu", "User3", "Pass3"));
        mUser.add(new User(4, "Tarja","", "User3", "Pass3"));
        mUser.add(new User(5, "Tarja","Turu", "", "Pass3"));
        mUser.add(new User(6, "Tarja","Turu", "User3", ""));

    }

    @After
    public void tearDown(){
        sut = null;
        mUser.removeAll(mUser);
    }


    @Test
    public void testIsUserValidWithNullValue(){
        mUser.add(null);
        User _expectedResult = mUser.get(4);
        Assert.assertFalse(sut.isUserValid(_expectedResult));
    }

    @Test
    public void testIsUserValidWithEmptyString(){
        User _expectedResult = mUser.get(1);
        Assert.assertFalse(sut.isUserValid(_expectedResult));
    }

    @Test
    public void testIsUserValidWithEmptyFirst(){
        User _expectedResult = mUser.get(2);
        Assert.assertFalse(sut.isUserValid(_expectedResult));
    }
    @Test
    public void testIsUserValidWithEmptyLast(){
        User _expectedResult = mUser.get(3);
        Assert.assertFalse(sut.isUserValid(_expectedResult));
    }
    @Test
    public void testIsUserValidWithEmptyUser(){
        User _expectedResult = mUser.get(4);
        Assert.assertFalse(sut.isUserValid(_expectedResult));
    }
    @Test
    public void testIsUserValidWithEmptyPass(){
        User _expectedResult = mUser.get(5);
        Assert.assertFalse(sut.isUserValid(_expectedResult));
    }

}
