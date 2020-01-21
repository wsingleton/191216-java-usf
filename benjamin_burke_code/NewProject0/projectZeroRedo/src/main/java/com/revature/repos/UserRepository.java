package com.revature.repos;

import com.revature.models.User;

import com.revature.util.ConnectionFactory;

import java.sql.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

//import static com.revature.AppDriver;

public class UserRepository implements CrudRepository<User> {

    private Integer key;
    private HashMap<Integer, User> userDb;

    public Optional<User> findUserByUsername(String username) {

        Optional<User> _user = Optional.empty();

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "select * from project0bank.users WHERE user_name = ?" ;

            PreparedStatement pstmt = conn.prepareStatement(sql);
//            username = "\'" + username + "\'";
            pstmt.setString(1, username);

            ResultSet rs = pstmt.executeQuery();
            Set<User> set = mapResultSet(rs);

            if (!set.isEmpty()) {
                _user = set.stream().findFirst();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return _user;

    }

    public Optional<User> findUserByCredentials(String username, String password) {

        Optional<User> _user = Optional.empty();
        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "select * from users where user_name = ? and user_pass = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);

            ResultSet rs = pstmt.executeQuery();
            Set<User> set = mapResultSet(rs);

            if (!set.isEmpty()) {
                _user = set.stream().findFirst();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return _user;
    }



    @Override
    public void save(User newObj) {

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "insert into users VALUES (0, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql, new String[] {"user_id"});
            pstmt.setString(1, newObj.getFirstName());
            pstmt.setString(2, newObj.getLastName());
            pstmt.setString(3, newObj.getUsername());
            pstmt.setString(4, newObj.getPassword());

            int rowsInserted = pstmt.executeUpdate();

            if (rowsInserted != 0) {

                ResultSet rs = pstmt.getGeneratedKeys();

                while (rs.next()) {
                    newObj.setUserId(rs.getInt(1));
                }

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

            @Override
            public Set<User> findAll() {

                Set<User> users = new HashSet<>();
                try ( Connection conn = ConnectionFactory.getInstance().getConnection()){

                    String sql = "SELECT * FROM project0Bank.users";
                    Statement stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery(sql);
                    users = mapResultSet(rs);

                } catch (SQLException e) {
                    System.err.println("Can't establish connection");
                }

                return users;

            }

            @Override
            public Optional findById (Integer id){
                return Optional.empty();
            }

    @Override
    public Boolean update(User updatedObj) {
        return null;
    }


    @Override
            public Boolean deleteById (Integer id){
                return null;
            }


            private Set<User> mapResultSet(ResultSet rs) throws SQLException {
                Set<User> users = new HashSet<>();
                while (rs.next()) {
                    User temp = new User();
                    temp.setUserId(rs.getInt("user_id"));
                    temp.setUsername(rs.getString("user_name"));
                    temp.setPassword(rs.getString("user_pass"));
                    temp.setFirstName(rs.getString("user_fn"));
                    temp.setLastName(rs.getString("user_ln"));
                    users.add(temp);
                }
                return users;
            }
        }
