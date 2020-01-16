package com.revature.repositories;

import com.revature.models.Account;
import com.revature.models.Role;
import com.revature.models.User;

import javax.xml.transform.Result;

import static com.revature.MockBankDriver.router;
import static com.revature.util.ConnectionFactory.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;


public class UserRepository {


    public Boolean save(Set<User> users, Integer isJoint) {
        //todo figure out permissions needed for new users
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
            for(User u: users) {
                String sql = "SELECT ID FROM USERS WHERE ID=?";
                PreparedStatement ps = getCon().prepareStatement(sql);
                ps.setInt(1,u.getID());
                ResultSet rs = ps.executeQuery();
                if (!rs.isBeforeFirst()) {
                }else{
                    System.out.println("The username, " + u.getUserName() + ", you chose is taken.");
                    router.navigate("/home");
                }
            }
            User[] userArray = new User[users.size()];
            userArray = users.toArray(userArray);
            String sql = "INSERT ALL";
            for(User u : users) {
                sql += " into USERS values (?,?,?,?,?,?,?,?,?) ";
            }
            sql += " SELECT * FROM dual";
            PreparedStatement ps = getCon().prepareStatement(sql);
            for(int i = 0,  j = 1 ; j < userArray.length*9; i++) {
                ps.setInt(j,userArray[i].getID()); j++;
                ps.setString(j,userArray[i].getUserName()); j++;
                ps.setInt(j,userArray[i].hashCode()); j++;
                ps.setString(j,userArray[i].getFirstName()); j++;
                ps.setString(j,userArray[i].getLastName()); j++;
                ps.setInt(j,4); j++;
                ps.setInt(j,userArray[i].getTu()); j++;
                ps.setInt(j,userArray[i].getExp()); j++;
                ps.setInt(j,isJoint); j++;
            }
            int rowsReturned = ps.executeUpdate();

            if(isJoint == 1){
                sql = "SELECT MAX(joint_id) as joint_id FROM isjoint";
                ps = getCon().prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                int joint_id = 0;
                if(!rs.isBeforeFirst()){
                    joint_id = 1;
                }else {
                    while (rs.next()) {
                        joint_id = rs.getInt(1) + 1;
                    }
                }
                sql = "INSERT ALL";
                for (User u:
                     users) {
                    sql += " INTO isjoint VALUES (?,?) ";
                }
                sql += " SELECT * FROM dual";
                ps = getCon().prepareStatement(sql);
                for(int i = 0,  j = 1 ; j < users.size()*2; i++) {
                    ps.setInt(j,joint_id); j++;
                    ps.setInt(j,userArray[i].getID()); j++;
                }
                rowsReturned += ps.executeUpdate();
            }
            if(isJoint == 1){
                if(rowsReturned == users.size()*2){
                    return true;
                }else{
                    return false;
                }
            }else {
                if (rowsReturned == users.size()){
                    return true;
                }
                else {
                    return false;
                }
            }

        } catch (Exception e) {
            System.out.println("Failed: Driver Error: " + e.getMessage());
            router.navigate("/home");
        }
        return false;
    }
    //TODO Optional is a way of avoiding returning nulls, no NullPointerException
    public User findById(Integer id) {
        User user = new User();
        try {
            String sql = "SELECT * FROM users JOIN role ON users.role = role.role_id  WHERE ID = ?";
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Integer idNo = rs.getInt("ID");
                String fname =rs.getString("FNAME");
                String lname =rs.getString("LNAME");
                String uname =rs.getString("USERNAME");
                String pw =rs.getString("PASSWORD");
                Role role = Role.valueOf(rs.getString("ROLE_NAME"));
                user = new User(idNo,fname,lname,uname,pw,role);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }



    public boolean deleteById(Integer id) {
        try {
            String sql = "DELETE FROM ACCOUNT WHERE ID = " + id;
            Statement st = getCon().createStatement();
            int num = st.executeUpdate(sql);
            sql = "{call cs_procedure (?,?)}";
            CallableStatement calls = getCon().prepareCall(sql);
            calls.setInt(1,id);
            calls.registerOutParameter(2, Types.NUMERIC);
            num += calls.executeUpdate();
            if(num > 0){
                return true;
            }
        }catch(SQLException sqlE){
            sqlE.getSQLState();
        }
        return false;
    }

    //TODO finish credit score method in UserRepository
    public static ArrayList<Integer> creditScore(Integer id){
        ArrayList<Integer> arrayInt = new ArrayList<>();
        Set<Integer> userIdSet = new HashSet<>();
        Integer tu, exp, cs, isjoint = 0, joint_id = 0, user_id = 0;
        try{

            String sql = "SELECT isjoint FROM users WHERE id = ?";
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            if(rs.isBeforeFirst()) {
                while (rs.next()) {
                    isjoint = rs.getInt(1);
                }
            }
            if(isjoint == 1){
                sql = "SELECT joint_id FROM isjoint WHERE user_id = ?";
                ps = getCon().prepareStatement(sql);
                ps.setInt(1,id);
                rs = ps.executeQuery();
                if(rs.isBeforeFirst()) {
                    while (rs.next()) {
                        joint_id = rs.getInt("joint_id");
                    }
                }
                sql = "SELECT user_id FROM isjoint WHERE joint_id = ?";
                ps = getCon().prepareStatement(sql);
                ps.setInt(1,joint_id);
                rs = ps.executeQuery();
                if(rs.isBeforeFirst()) {
                    while (rs.next()) {
                        user_id = rs.getInt("user_id");
                        userIdSet.add(user_id);
                    }
                }
                for (Integer i:
                     userIdSet) {
                    sql = "SELECT TRANSUNION, EXPERIAN FROM USERS WHERE ID = ?";
                    ps = getCon().prepareStatement(sql);
                    ps.setInt(1,i);
                    rs = ps.executeQuery();
                    if(rs.isBeforeFirst()) {
                        while (rs.next()) {
                            tu = rs.getInt("TRANSUNION");
                            exp = rs.getInt("EXPERIAN");
                            cs = (tu+exp)/2;
                            arrayInt.add(cs);
                        }
                    }
                }
            }else {
                sql = "SELECT TRANSUNION, EXPERIAN, isjoint FROM USERS WHERE ID = ?";
                ps = getCon().prepareStatement(sql);
                ps.setInt(1, id);
                rs = ps.executeQuery();
                if (rs.isBeforeFirst()) {
                    while (rs.next()) {
                        tu = rs.getInt("TRANSUNION");
                        exp = rs.getInt("EXPERIAN");
                        cs = (tu + exp) / 2;
                        arrayInt.add(cs);
                    }
                }
            }
        }catch (SQLException sqlE){
            sqlE.getSQLState();
        }
        return arrayInt;
    }
}
