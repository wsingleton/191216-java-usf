package com.revature.revabooks;

import com.revature.revabooks.util.ConnectionFactory;

import java.sql.*;

public class Test {

    public static void main (String ... args) throws SQLException {
        Connection con = ConnectionFactory.getInstance().getConnection();
        if(con == null){
            System.out.println("Connection Failed");
        }else{
            System.out.println("Connection successful!");
        }

//        try(Connection conn = ConnectionFactory.getInstance().getConnection()){
//
//            String sql = "SELECT * FROM revabook.users WHERE first_name = ?";
//            PreparedStatement poststm = conn.prepareStatement(sql);
//            poststm.setString(1, "Wezley");
//
//            ResultSet rs = poststm.executeQuery();
//            while(rs.next()){
//
//                int userId = rs.getInt("user_id");
//                String fname = rs.getString("first_name");
//                String username = rs.getString("username");
//                System.out.println("Userid: " + userId + " First name: " + fname + " Username: " + username);
//            }
//
//
//        }catch(SQLException e){
//            e.printStackTrace();
//        }
    }
}
