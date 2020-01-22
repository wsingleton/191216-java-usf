package com.reavture.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.reavture.pojo.User;
import com.reavture.util.ConnectionFactory;


import oracle.jdbc.internal.OracleTypes;

//import oracle.jdbc.OracleTypes;

public class UserDao implements Dao <User, Integer>{

    @Override
    public List<User> findAll() {

        List<User> users = new ArrayList<User>();

        try(Connection conn = ConnectionFactory.getInstance().getConnection()){

            String sql = "{ call GET_ALL_USERS(?) }";

            CallableStatement cs = conn.prepareCall(sql);

            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.execute();

            ResultSet rs = (ResultSet) cs.getObject(1);

            while(rs.next()) {

                User temp = new User();
                temp.setUser_id(rs.getInt(1));
                temp.setUsername(rs.getString(2));
                temp.setEmail(rs.getString(3));
                temp.setLastname(rs.getString(4));
                temp.setFirstname(rs.getString(5));
                temp.setPassword(rs.getString(6));
                users.add(temp);

            }
        } catch (SQLException e) {

            e.printStackTrace();

        }
        return users;

    }

    @Override
    public User findById(Integer id) {

        User user = null;

        try(Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "SELECT * FROM USERS WHERE USER_ID = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,  id);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {

                user = new User();
                user.setUser_id(rs.getInt(1));
                user.setUsername(rs.getString(2));
                user.setEmail(rs.getString(3));
                user.setLastname(rs.getString(4));
                user.setFirstname(rs.getString(5));
                user.setPassword(rs.getString(6));

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return user;
    }

    @Override
    public User save(User obj) {

        try(Connection conn = ConnectionFactory.getInstance().getConnection()) {

            conn.setAutoCommit(false);

            String sql = "INSERT INTO USERS (USERNAME, EMAIL, LASTNAME, FIRSTNAME, PASSWORD)"
                    + " VALUES(?, ?, ?, ?, ?)";

            String[] keyNames = {"USER_ID"};

            System.out.println(obj.getUsername());

            PreparedStatement ps = conn.prepareStatement(sql, keyNames);
            ps.setString(1, obj.getUsername());
            ps.setString(2, obj.getEmail());
            ps.setString(3, obj.getLastname());
            ps.setString(4, obj.getFirstname());
            ps.setString(5, obj.getPassword());


            int numRows = ps.executeUpdate();
            if(numRows > 0) {

                ResultSet pk = ps.getGeneratedKeys();

                while(pk.next()) {

                    obj.setUser_id(pk.getInt(1));

                }

                conn.commit();

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return obj;

    }

    @Override
    public User update(User obj) {

        try(Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "UPDATE USERS SET USERNAME = ?, EMAIL = ?,  LASTNAME = ?, FIRSTNAME = ?, PASSWORD = ? WHERE USER_ID = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,  obj.getUsername());
            ps.setString(2, obj.getEmail());
            ps.setString(3,  obj.getLastname());
            ps.setString(4, obj.getFirstname());
            ps.setString(5, obj.getPassword());
            ps.setInt(6, obj.getUser_id());
            ps.executeUpdate();


        } catch (SQLException e) {

            e.printStackTrace();

        }

        return null;
    }


    public void delete(User obj) {
        // TODO Auto-generated method stub

    }

}