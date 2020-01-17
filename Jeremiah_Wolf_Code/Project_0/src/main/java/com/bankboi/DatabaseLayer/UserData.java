package com.bankboi.DatabaseLayer;

import com.bankboi.plainjava.Users;
import com.bankboi.util.InternetConnection;
import oracle.jdbc.OracleTypes;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserData implements Database<Users, Integer>{


    @Override
    public List<Users> findAll() {

        List<Users> users = new ArrayList<Users>();

        try(Connection conn = InternetConnection.getInstance().getConnection()){

            String sql = "{ call RETRIEVE_USERS_BANK(?) }";

            CallableStatement cs = conn.prepareCall(sql);

            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.execute();

            ResultSet rs = (ResultSet) cs.getObject(1);

            while(rs.next()) {

                Users temp = new Users();
                temp.setId(rs.getInt(1));
                temp.setFirstName(rs.getString(2));
                temp.setLastName(rs.getString(3));
                temp.setUsername(rs.getString(4));
                temp.setPassword(rs.getString(5));
                users.add(temp);

            }
        } catch (SQLException e) {

            e.printStackTrace();

        }
        return users;

    }

    @Override
    public Users findById(Integer id) {

        Users user = null;

        try(Connection conn = InternetConnection.getInstance().getConnection()) {

            String sql = "SELECT * FROM BANK_USER WHERE USER_ID = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,  id);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {

                user = new Users();
                user.setId(rs.getInt(1));
                user.setFirstName(rs.getString(2));
                user.setLastName(rs.getString(3));
                user.setUsername(rs.getString(4));
                user.setPassword(rs.getString(5));

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return user;
    }

    @Override
    public Users save(Users obj) {

        try(Connection conn = InternetConnection.getInstance().getConnection()) {

            conn.setAutoCommit(false);

            String sql = "INSERT INTO BANK_USER (FirstName, LastName, UserName, Password)"
                    + " VALUES(?, ?, ?, ?)";

            String[] keyNames = {"USER_ID"};

            PreparedStatement ps = conn.prepareStatement(sql, keyNames);
            ps.setString(1, obj.getFirstName());
            ps.setString(2, obj.getLastName());
            ps.setString(3, obj.getUsername());
            ps.setString(4, obj.getPassword());


            int numRows = ps.executeUpdate();
            if(numRows > 0) {

                ResultSet pk = ps.getGeneratedKeys();

                while(pk.next()) {

                    obj.setId(pk.getInt(1));

                }

                conn.commit();

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return obj;

    }

    @Override
    public Users update(Users obj) {

        try(Connection conn = InternetConnection.getInstance().getConnection()) {

            String sql = "UPDATE BANK_USER SET FirstName = ?, LastName = ?, UserName = ?, Password = ? WHERE USER_ID = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,  obj.getFirstName());
            ps.setString(2, obj.getLastName());
            ps.setString(3,  obj.getUsername());
            ps.setString(4, obj.getPassword());
            ps.setInt(5, obj.getId());
            ps.executeUpdate();


        } catch (SQLException e) {

            e.printStackTrace();

        }

        return null;
    }

    @Override
    public void delete(Users obj) {
        // TODO Auto-generated method stub

    }

}