package com.revature.repo;

import com.revature.pojos.Accounts_Bank;
import com.revature.pojos.User;
import com.revature.util.ConnectionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;

public class UserRepoTest {

    UserRepo sut;
    UserRepo userRepo = mock(UserRepo.class);
    List<User> users = new ArrayList<>();
    ConnectionFactory mockConnectionFactory = mock(ConnectionFactory.class);
    Connection mockConn = mock(Connection.class);
    List <User> mockUser = new ArrayList<>();

    @Before
    public void setUp() {


        sut = new UserRepo();
        mockUser.add(new User("Jaret","Ca","jca","j16"));
        mockUser.add(new User("Jaredd","Car","jcar","j15"));
        mockUser.add(new User("Jar","Cart","jcart","j14"));
        mockUser.add(new User("Jare","Carte","jcarte","j13"));


    }
    @After
    public void tearDown() {

        sut = null;
        mockUser.remove(mockUser);

    }

    @Test
    public void findUser() {

    }

    @Test
    public void saveUser() {

    }

    @Test
    public void updateUser() {

    }
}