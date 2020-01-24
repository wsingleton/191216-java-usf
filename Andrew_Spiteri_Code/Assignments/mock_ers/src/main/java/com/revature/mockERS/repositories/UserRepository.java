package com.revature.mockERS.repositories;

import com.revature.mockERS.models.ERS_Users;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Optional;

import static com.revature.mockERS.util.ConnectionFactory.getCon;

public class UserRepository {

    public Boolean addUser(ERS_Users user){
        String sql = "INSERT INTO ers_users (ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id) VALUES (?,?,?,?,?,?)";
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1,user.getErsUsername());
            ps.setInt(2, user.hashCode());
            ps.setString(3, user.getUser_first_name());
            ps.setString(4, user.getUser_last_name());
            ps.setString(5,user.getUser_email());
            ps.setInt(6, 2);
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

    public Optional<ERS_Users> findByCredentials(String username, String password){
        String sql = "SELECT * FROM ers_users WHERE ers_username = ?";
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if(rs.isBeforeFirst()){
                while(rs.next()){
                    Integer id = rs.getInt("ers_users_id");
                    String un = rs.getString("ers_username");
                    String pw = rs.getString("ers_password");
                    String fn = rs.getString("user_first_name");
                    String ln = rs.getString("user_last_name");
                    String email = rs.getString("user_email");
                    ERS_Users user = new ERS_Users(id, un, pw, fn, ln, email);
                    if(user.getErsUsername().equals(username) && user.hashCode() == Objects.hash(password)) {
                        return Optional.of(user);
                    }
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public Optional<ERS_Users> findById(Integer id){
        String sql = "SELECT * FROM ers_users WHERE ers_username = ?";
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.isBeforeFirst()){
                while(rs.next()){
                    Integer u_id = rs.getInt("ers_users_id");
                    String un = rs.getString("ers_username");
                    String pw = rs.getString("ers_password");
                    String fn = rs.getString("user_first_name");
                    String ln = rs.getString("user_last_name");
                    String email = rs.getString("user_email");
                    ERS_Users user = new ERS_Users(id, un, pw, fn, ln, email);
                    return Optional.of(user);
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public Optional<ERS_Users> findByUsername(String username){
        String sql = "SELECT * FROM ers_users WHERE ers_username = ?";
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if(rs.isBeforeFirst()){
                while(rs.next()){
                    String un = rs.getString("ers_username");
                    String pw = rs.getString("ers_password");
                    String fn = rs.getString("user_first_name");
                    String ln = rs.getString("user_last_name");
                    String email = rs.getString("user_email");
                    ERS_Users user = new ERS_Users(un, pw, fn, ln, email);
                    return Optional.of(user);
                }
            }
        }catch (SQLException e){
            System.out.println("Exception in findByUsername.");
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
