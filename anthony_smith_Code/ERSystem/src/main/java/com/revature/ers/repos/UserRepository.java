package com.revature.ers.repos;

import com.revature.ers.models.*;
import com.revature.ers.repos.*;
import com.revature.ers.util.*;

import java.sql.*;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;



public class UserRepository implements CrudRepository <User> {

    public Optional<User> findUserByCredentials(String username, String password) {

        Optional<User> user = Optional.empty();

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            System.out.println(conn);
            String sql = "Select * FROM ERS_USERS WHERE ERS_USERNAME = ? AND ERS_PASSWORD = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            System.out.println(pstmt);
            ResultSet rs = pstmt.executeQuery();
            user = mapResultSet(rs).stream().findFirst();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;

    }


    public Set<User> findUsersByRole(Role role) {

        Set<User> users = new HashSet<>();

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "SELECT * FROM ERS_USES WHERE USER_ROLE_ID = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, role.getId());

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public Optional<User> findUserByUsername(String username) {

        Optional<User> user = Optional.empty();

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "SELECT * FROM ERS_USERS WHERE ESR_USERNAME = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);

            ResultSet rs = pstmt.executeQuery();
            user = mapResultSet(rs).stream().findFirst();


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }



    public void save(User newObj){

        boolean successful=false;

        try(Connection conn = ConnectionFactory.getInstance().getConnection()){

            String sql = "INSERT INTO ERS_USERS VALUES(0, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql, new String[] {"ERS_USER_ID"});
            pstmt.setString(1, newObj.getUsername());
            pstmt.setString(2, newObj.getPassword());
            pstmt.setString(3, newObj.getFirstname());
            pstmt.setString(4, newObj.getLastname());
            pstmt.setString(5, newObj.getEmail());
            pstmt.setInt(6, newObj.getRole().getId());

            int rowsInserted = pstmt.executeUpdate();

            if (rowsInserted !=0 ){

                ResultSet rs = pstmt.getGeneratedKeys();

                while(rs.next()){
                    newObj.setId(rs.getInt(1));
                }
            }


        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Set<User> findAll() {

        Set<User> users = new HashSet<>();

        try (Connection conn = ConnectionFactory.getInstance().getConnection()){

            String sql = "SELECT * FROM ERS_USERS";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            users = mapResultSet(rs);

        }catch (SQLException e){
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public Optional<User> findById(int id) {

        Optional<User> user = Optional.empty();

        try (Connection conn = ConnectionFactory.getInstance().getConnection()){

            String sql = "SELECT * FROM ERS_USERS WHERE ERS_USERS_ID = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);

            ResultSet rs = pstmt.executeQuery();
            user = mapResultSet(rs).stream().findFirst();

        }catch (SQLException e){
            e.printStackTrace();
        }

        return user;
    }

    @Override
    public boolean update(User updateObj) {

        boolean updateSuccessful = false;

        try (Connection conn = ConnectionFactory.getInstance().getConnection()){

            String sql = "UPDATE ERS_USERS SET ERS_USERNAME = ?, ERS_PASSWORD = ?, ERS_FIRST_NAME = ? ," +
                    "ERS_LAST_NAME = ?, ERS_EMAIL = ?, WHERE USER_ROLE_ID = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, updateObj.getUsername());
            pstmt.setString(2, updateObj.getPassword());
            pstmt.setString(3, updateObj.getFirstname());
            pstmt.setString(4, updateObj.getLastname());
            pstmt.setString(5, updateObj.getEmail());
            pstmt.setInt(5, updateObj.getId());

            int rowsUpdataed = pstmt.executeUpdate();

            if (rowsUpdataed > 0){
                updateSuccessful = true;
            }

        }catch (SQLException e){

        }

        return updateSuccessful;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }

    private Set<User> mapResultSet(ResultSet rs) throws SQLException{

        Set<User> users = new HashSet<>();

        while (rs.next()){
            User temp = new User();
            temp.setId(rs.getInt("ERS_USERS_ID"));
            temp.setUsername(rs.getString("ERS_USERNAME"));
            temp.setPassword(rs.getString("ERS_PASSWORD"));
            temp.setFirstname(rs.getString("USER_FIRST_NAME"));
            temp.setLastname(rs.getString("USER_LAST_NAME"));
            temp.setEmail(rs.getString("USER_EMAIL"));
            temp.setRole(Role.getByID(rs.getInt("USER_ROLE_ID")));
            users.add(temp);
        }

        return users;
    }

}
