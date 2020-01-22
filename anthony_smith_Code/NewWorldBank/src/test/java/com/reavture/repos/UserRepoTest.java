package com.reavture.repos;

import com.reavture.dao.UserDao;
import com.reavture.pojo.User;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;



//   School newSchool = schoolService.addSchool(school);
//           assertNotNull("School Type object should not null ", newSchool);




public class UserRepoTest {

    User

    @Before

     public void setup() {



        sut = new UserRepo(user);

        List<User> mockUsers = new List<User>();


        mockUsers.add(new User( "l_light", "yagami@yahoo.com", "Yagami", "Light", "Goldwatch11"));
        mockUsers.add(new User( "misamisa", "misamisa@aol.com", "Amane", "Misa", "ilovelight"));
        mockUsers.add(new User( "l_Lawliet", "lawliet@gmail.com", "Lawliet", "Hepburn", "iamjustice"));
        mockUsers.add(new User("near_89", "near@aol.com", "", "River", "river@yahoo.com"));

    }


    @Test

    public void findAllUser() {
        List <User> findAllUser();

        when(UserRepo.findAll()).thenReturn(mockUsers);
        Set<User> result = sut.findAll();
        assertNotNull(result);
        assertEquals(4, result.size());

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