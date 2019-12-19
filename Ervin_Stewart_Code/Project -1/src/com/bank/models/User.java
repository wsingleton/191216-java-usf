package com.bank.models;

import com.bank.services.UserValidation;

public class User {


    private int Id;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private  Role role;

    public User() {
        super();
    }

    public User(String Firstname, String Lastname, String Username, String pw, Role Role){
        this.role = Role;
        this.firstName = Firstname;
        this.lastName = Lastname;
        this.userName = Username;
        this.role = Role;
        this.password = pw;
    }
    public User(int id,String Firstname, String Lastname, String Username, String pw, Role Role){
        this(Firstname,Lastname,Username,pw,Role);
        this.Id= id;

    }




    public static void setEmail(String email){
     boolean continuation=false;
   do {
       if (UserValidation.isEmail(email)) {
           this.Email= email;
           continuation = true;
       } else

   }while(!continuation);

 }
}
