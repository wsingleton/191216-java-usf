public class User {
    private String username, password, firstName, lastName, id, role;
    private double account;
    User(String[] user){
        username = user[0];
        password = user[1];
        firstName = user[2];
        lastName = user[3];
        id = user[4];
        role = user[5];
    }

}
