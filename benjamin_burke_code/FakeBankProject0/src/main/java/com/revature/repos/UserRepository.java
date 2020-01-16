package com.revature.repos;

import com.revature.models.Account;
import com.revature.models.User;
import com.revature.util.ConnectionFactory;

import java.sql.*;
import java.util.*;

public class UserRepository implements CrudRepository<User> {
    private Integer key;
    private HashMap<Integer, User> userDb;

    public Optional<User> findUserByUsername(String username) {

        Optional <User> user = Optional.empty();

        try(Connection conn = ConnectionFactory.getInstance().getConnection()){

            String sql = "SELECT * from users WHERE username = ? ";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);

            ResultSet rs = pstmt.executeQuery();
            Set<User> set = mapResultSet(rs);


            if(!set.isEmpty()) {
                user = set.stream().findFirst();
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

        return user;
    }

    public Optional<User> findUserByCredentials(String username, String password) {

        Optional<User> user =Optional.empty();
        try(Connection conn = ConnectionFactory.getInstance().getConnection()){

            String sql = " SELECT * FROM bank_app.users where username = ? and password = ? ";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);

            ResultSet rs = pstmt.executeQuery();
            Set<User> set = mapResultSet(rs);

            if(!set.isEmpty()) {
                user = set.stream().findFirst();
            }

        }catch (SQLException e){
            e.printStackTrace();
        }


        return user;
    }

    @Override
    public void save(User newObj) {

        try(Connection conn = ConnectionFactory.getInstance().getConnection()){

            Account acc = new Account();
            acc.setBalance(0.0);

            String sql = " INSERT INTO bank_app.users VALUES(0,?,?)";
//            String sql2 = "INSERT INTO bank_app.accounts VALUES(?,0)";

            //users
            PreparedStatement pstmt = conn.prepareStatement(sql, new String[]{"id"});
            //account
//            PreparedStatement pstm2 = conn.prepareStatement(sql2, new  String[]{"accountId"});
            // accounts
//            pstm2.setInt(1, acc.getAccountId());
//            pstm2.setDouble(2,acc.getBalance());
            // users
            pstmt.setString(1, newObj.getUsername());
            pstmt.setString(2, newObj.getPassword());


            int rowsInserted = pstmt.executeUpdate();
//            pstm2.executeUpdate();
            if(rowsInserted != 0){

                ResultSet rs = pstmt.getGeneratedKeys();

                while (rs.next()){
                    newObj.setId(rs.getInt(1));
                }
                System.out.println("You are now registered! Your new username is " + newObj);
                System.out.println("You balance is " + acc.getBalance());
            }

        }catch (SQLIntegrityConstraintViolationException e){
            e.printStackTrace();
        }

        catch (SQLException b){
            b.printStackTrace();
        }


    }

    public Set<User> findAll() {

        Set<User> users = new HashSet<>();
        try(Connection conn = ConnectionFactory.getInstance().getConnection()){

            String sql = " SELECT * FROM users";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            users = mapResultSet(rs);

        }catch (SQLException e){
            e.printStackTrace();
        }

        return users;
    }

    @Override
    public Optional<User> findById(Integer id){
        return Optional.empty();
    }

    @Override
    public Boolean update(User updatedObj){
        return true;
    }

    @Override
    public Boolean deleteById(Integer id){
        return (userDb.remove(id) !=null);
    }

    private Set<User> mapResultSet(ResultSet rs) throws SQLException{
        Set<User> users = new HashSet<>();
        while (rs.next()) {
            User temp = new User();
            temp.setId(rs.getInt("id"));
            temp.setUsername(rs.getString("username"));
            temp.setPassword(rs.getString("password"));
            users.add(temp);
        }
        return users;
    }
}
