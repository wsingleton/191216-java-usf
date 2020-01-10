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
        //todo figure out permissions needed for new users
        //todo figure out how to create a junction table
        /*
CREATE USER chinook
IDENTIFIED BY p4ssw0rd
DEFAULT TABLESPACE users
TEMPORARY TABLESPACE temp
QUOTA 10M ON users;

GRANT connect to chinook;
GRANT resource to chinook;
GRANT create session TO chinook;
GRANT create table TO chinook;
GRANT create view TO chinook;
         */
        try {
            Statement statement = getCon().createStatement();
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
                router.navigate("/home");

            }
        } catch (Exception e) {
            System.out.println("Failed: Driver Error: " + e.getMessage());
        }
        return false;
    }
    //TODO Optional is a way of avoiding returning nulls, no NullPointerException
    public User findById(Integer id) {
        User user = new User();
        try {
            String sql = "SELECT * FROM USERS WHERE ID = ?";
            PreparedStatement ps = getCon().prepareStatement(sql);
            //String sql = "SELECT * FROM USERS WHERE ID ="+  id;
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Integer idNo = rs.getInt("ID");
                String fname =rs.getString("FNAME");
                String lname =rs.getString("LNAME");
                String uname =rs.getString("USERNAME");
                String pw =rs.getString("PASSWORD");
                Role role = Role.valueOf(rs.getString("ROLE"));
                user = new User(idNo,fname,lname,uname,pw,role);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }

    public boolean update(User user) {

        return false;
    }

    @Override
    public boolean deleteById(Integer id) {
        try {
            Statement st = getCon().createStatement();
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
        Random rand = new Random();
        Integer tu, exp, cs;
        try{
            Statement st = getCon().createStatement();
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
