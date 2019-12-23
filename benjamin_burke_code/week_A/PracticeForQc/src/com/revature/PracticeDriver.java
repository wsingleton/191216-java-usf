package com.revature;
import com.revature.models.User;
import com.revature.models.Role;

public class PracticeDriver {
    public static void main(String[] args){

        User myUser= new User("Benji", "Burke", "Benji3193", "benjamin@gmail.com", "Bruce", Role.MEMBER );

        User newMember = new User();


        System.out.println(newMember);
        System.out.println(myUser);

    }
}
