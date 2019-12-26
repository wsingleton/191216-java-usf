package resources;
import com.revature.models.User;

import java.util.ArrayList;

public class UserService {
    static ArrayList<User> users;
    static{
        users = new ArrayList<User>();
        users.add(new User("username", "password"));

    }

    ArrayList<User>getAllUsers(){
        DAO dao= new DAO();
        return dao.readUsers();
    }
    public boolean exists(String username){
        ArrayList<User>users = getAllUsers();
        return users.stream().anyMatch(
                u->u.getUsername().equalsIgnoreCase(username));
    }
    public User getByUsername(String username) {
        return getAllUsers().stream().filter(u -> u.getUsername()
                .equalsIgnoreCase(username)).findFirst().get();
    }
    User addUser(String username, String password) {

        User u = new User(username, password);
        DAO dao = new DAO();
        dao.addUser(u);
        return u;
    }

}
