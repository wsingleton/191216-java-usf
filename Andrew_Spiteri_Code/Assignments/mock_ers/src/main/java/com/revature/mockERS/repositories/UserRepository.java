package com.revature.mockERS.repositories;

import com.revature.mockERS.models.ERS_Users;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.revature.mockERS.util.ConnectionFactory.getCon;

public class UserRepository {

    public Boolean addUser(ERS_Users user){
        String sql = "INSERT INTO ers_users (ers_username, ers_password, user_first_name, user_last_name, user_email) VALUES (?,?,?,?,?)";
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1,user.getErsUsername());
            ps.setInt(2, user.hashCode());
            ps.setString(3, user.getUser_first_name());
            ps.setString(4, user.getUser_last_name());
            ps.setString(5,user.getUser_email());
            Integer success = ps.executeUpdate();
            if(success == 1){
                return true;
            }
        }catch (SQLException e){
            //todo get rid of stacktrace
            e.printStackTrace();
        }
        return false;
    }

    public ERS_Users findByUsername(String username, Integer password){
        String sql = "SELECT * FROM ers_users WHERE ers_username = ?";
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if(rs.isBeforeFirst()){
                while(rs.next()){
                    //todo finish login function, figure out Optional
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
