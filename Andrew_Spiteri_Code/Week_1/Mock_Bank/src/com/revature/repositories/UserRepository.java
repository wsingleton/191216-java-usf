package com.revature.repositories;

import com.revature.models.Account;
import com.revature.models.Role;
import com.revature.models.User;

import static com.revature.MockBankDriver.router;
import static com.revature.util.ConnectionFactory.*;

import java.sql.*;
import java.util.Random;

//todo Implement interface for repository
public class UserRepository implements CrudRepository<User>{

    @Override
    public Boolean save(User user) {
        try {
            Connection con = createConnection();
            Statement statement = con.createStatement();
            String sql = "SELECT ID FROM USERS WHERE ID="+ user.getID();
            ResultSet rs = statement.executeQuery(sql);
            if(!rs.isBeforeFirst()){
                sql = "Insert into USERS values (" + user.getID() + ",'"
                        + user.getUserName() +"',"+user.hashCode()+",'"+user.getFirstName()+"','"+user.getLastName()+"','"+user.getRole()
                        + "'," + user.getTu().getScore() + "," + user.getExp().getScore() +")";
                int num = statement.executeUpdate(sql);
                if(num == 1){
                    return true;
                }
            }else{
                System.out.println("The username you chose is taken.");
                //TODO navigate to home screen
                router.navigate("/home");

            }
        } catch (Exception e) {
            System.out.println("Failed: Driver Error: " + e.getMessage());
        }
        return false;
    }
    //TODO Optional is a way of avoiding returning nulls, no NullPointerException
    public User findById(Integer id) {
        try {
            Connection con= createConnection();
            Statement statement = con.createStatement();
            String sql = "SELECT * FROM USERS WHERE ID ="+  id;
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                Integer idNo = rs.getInt("ID");
                String fname =rs.getString("FNAME");
                String lname =rs.getString("LNAME");
                String uname =rs.getString("USERNAME");
                String pw =rs.getString("PASSWORD");
                Role role = Role.valueOf(rs.getString("ROLE"));
                User user = new User(idNo,fname,lname,uname,pw,role);
                return user;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public boolean update(User user) {

        return false;
    }

    @Override
    public boolean deleteById(Integer id) {
        Connection con = createConnection();
        try {
            Statement st = con.createStatement();
            String sql = "DELETE FROM ACCOUNT WHERE ID = " + id;
            int num = st.executeUpdate(sql);
            sql = "DELETE FROM USERS WHERE ID = " + id;
            num += st.executeUpdate(sql);
            if(num > 0){
                return true;
            }
        }catch(SQLException sqlE){
            sqlE.getSQLState();
        }
        return false;
    }

    //TODO finish credit score method in UserRepository
    public static Integer creditScore(Integer id){
        Connection con = createConnection();
        Random rand = new Random();
        Integer tu, exp, cs;
        try{
            Statement st = con.createStatement();
            String sql = "SELECT TRANSUNION, EXPERIAN FROM USERS WHERE ID = " + id;
            ResultSet rs = st.executeQuery(sql);
            if(rs.isBeforeFirst()){
                while(rs.next()){
                    tu = rs.getInt("TRANSUNION");
                    exp = rs.getInt("EXPERIAN");
                    cs = (tu+exp)/2;
                    return cs;
                }
            }
        }catch (SQLException sqlE){
            sqlE.getSQLState();
        }
        return 0;
    }
}
