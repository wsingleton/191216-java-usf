package repositories;

import com.revature.models.Account;
import com.revature.models.Role;
import com.revature.models.User;
import com.revature.repositories.UserRepository;
import org.junit.*;

import java.io.*;
import java.util.Scanner;

public class UserRepositoryTest {

    User user;

    @Before
    public void setUp() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your id: ");
        Integer id = scanner.nextInt();
        System.out.print("Enter you fn: ");
        String fn = scanner.next();
        System.out.print("Enter you ln: ");
        String ln = scanner.next();
        System.out.print("Enter you un: ");
        String un = scanner.next();
        System.out.print("Enter you pw: ");
        String pw = scanner.next();

        user = new User(id,fn, ln, un, pw, Role.MEMBER);
    }
    @After
    public void tearDown(){
        user = null;
    }
    @Ignore
    public void saveNewUserTest(){
        UserRepository userRepository = new UserRepository();
        //Boolean bool = userRepository.save(user);
        //Assert.assertTrue("The number of records inserted should be equal to one.",bool == true);
    }
    @Ignore
    public void findAllUsers(){
        //User
    }
}

