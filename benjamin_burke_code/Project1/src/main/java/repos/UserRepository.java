package repos;

import com.revature.project1.models.Role;
import com.revature.project1.models.User;
import com.revature.project1.util.ConnectionFactory;

import java.sql.Connection;
import java.util.HashSet;
import java.util.Set;

public class UserRepository  implements CrudRepository<User>{

    public Set<User> findUsersByRole(Role role) {
        Set<User> users = new HashSet<>();
            try (Connection conn ConnectionFactory.getInstance().getConnection()){

            }
        }
    }
}
