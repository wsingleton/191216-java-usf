package repos;

import com.revature.revabook.models.Role;
import com.revature.revabook.models.User;

import java.util.HashMap;
import java.util.Set;

public class UserRepository implements CrudRepository<User> {

    private Integer key;
    private HashMap<Integer, User> userDb;
    {

        key = 1;
        userDb = new HashMap<>();
        userDb.put(key, new User(key, "Wezley", "Singleton", "wsingleton", "p4ssw0rd", Role.ADMIN)); key++;
        userDb.put(key, new User(key, "Steven", "Kelsey", "wsingleton", "revature", Role.MANAGER)); key++;
        userDb.put(key, new User(key, "Wezley", "Singleton", "wsingleton", "p4ssw0rd", Role.PREMIUM_MEMBER)); key++;
        userDb.put(key, new User(key, "Wezley", "Singleton", "wsingleton", "p4ssw0rd", Role.BASIC_MEMBER)); key++;
        userDb.put(key, new User(key, "Trevin", "Singleton", "wsingleton", "p4ssw0rd", Role.ADMIN)); key++;
    }


    @Override
    public void save(User newObj)  {
       newObj.setId(key);
       userDb.put(key++, newObj);
       key++;

    }

    @Override
    public Set<User> findAll

}
