package com.revature.revabooks.repositories;

import com.revature.revabooks.models.Role;
import com.revature.revabooks.models.User;
import com.revature.revabooks.util.ConnectionFactory;

import java.sql.*;
import java.util.*;

public class UserRepository implements CrudRepository<User> {

    private Integer key;
    private HashMap<Integer, User> userDb;

    {
        key = 1;
        userDb = new HashMap<>();
        userDb.put(key, new User(key, "Wezley", "Singleton", "wsingleton", "p4ssw0rd", Role.ADMIN)); key++;
        userDb.put(key, new User(key, "Steven", "Kelsey", "skelsey", "revature", Role.MANAGER)); key++;
        userDb.put(key, new User(key, "Blake", "Kruppa", "bkruppa", "javascript", Role.PREMIUM_MEMBER)); key++;
        userDb.put(key, new User(key, "Robert", "Connell", "rconnell", "password", Role.BASIC_MEMBER)); key++;
        userDb.put(key, new User(key, "Trevin", "Chester", "tchester", "humans", Role.ADMIN)); key++;
        //userDb.forEach((k,v) -> System.out.println(v.toString()));
    }


    @Override
    public void save(User u) {
        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "INSERT INTO rbs_app.users VALUES (0, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql, new String[] {"user_id"});
            pstmt.setString(1, u.getUsername());
            pstmt.setString(2, u.getPassword());
            pstmt.setString(3, u.getFirstName());
            pstmt.setString(4, u.getLastName());
            pstmt.setInt(5, u.getRole().ordinal() + 1);
            int rowsInserted = pstmt.executeUpdate();

            if (rowsInserted != 0) {

                ResultSet rs = pstmt.getGeneratedKeys();

                while (rs.next()) {
                    u.setId(rs.getInt(1));
                }
            }

        } catch (SQLIntegrityConstraintViolationException e) { e.printStackTrace(); }
        catch (SQLException e) { e.printStackTrace(); }
    }

    @Override
    public Set<User> findAll() {
        Set<User> users = new HashSet<>();

        try(Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "SELECT * FROM rbs_app.users";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            users = mapResultSet(rs);

        } catch (SQLException e) { e.printStackTrace(); }

        return users;
    }

    @Override
    public Optional<User> findById(int id) {
        return null;
    }

    @Override
    public boolean update(User u) {
        return false;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }

    public Set<User> findUsersByRole(Role role) {

        return null;
    }

    public Optional<User> findUserByUserName(String username) {

        Optional<User> _user = Optional.empty();

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "SELECT * FROM rbs_app.users WHERE username = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            Set<User> users = mapResultSet(rs);
            if(!users.isEmpty()) _user = users.stream().findFirst();

        } catch (SQLException e) { e.printStackTrace(); }

        return _user;

    }

    public Optional<User> findUserByCredentials(String username, String pw) {

        Optional<User> _user = Optional.empty();

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "SELECT * FROM rbs_app.users WHERE username = ? AND password = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, pw);

            ResultSet rs = pstmt.executeQuery();
            Set<User> users = mapResultSet(rs);
            if(!users.isEmpty()) _user = users.stream().findFirst();


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return _user;
    }

    private Set<User> mapResultSet(ResultSet rs) throws SQLException {

        Set<User> users = new HashSet<>();

        while(rs.next()) {
            User temp = new User();
            temp.setId(rs.getInt("user_id"));
            temp.setUsername(rs.getString("username"));
            temp.setPassword(rs.getString("password"));
            temp.setFirstName(rs.getString("first_name"));
            temp.setLastName(rs.getString("last_name"));
            temp.setRole(Role.getRoleByID(rs.getInt("role_id")));    //come back to this
            users.add(temp);
        }

        return users;

    }
}
