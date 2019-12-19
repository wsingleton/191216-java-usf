package com.revature;
import com.revature.models.Role;
import com.revature.models.User;
public class ObjectDriver {
    public static void main(String[]args){
User myUser = new User(1, "Alice", "Anderson", "a.anderson","p4ssord", Role.ADMIN);

User otherUser=new User("Bob","Bailey","b.bailey","password",Role.MEMBER);
User defaultUser =new User();
System.out.println(myUser);
System.out.println(myUser.hashCode());

String userInput="Alice.Anderson";
myUser.setUsername(userInput);
System.out.println(myUser);


    }
}
