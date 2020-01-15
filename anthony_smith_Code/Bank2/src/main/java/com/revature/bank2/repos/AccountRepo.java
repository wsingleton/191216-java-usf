package com.revature.bank2.repos;

import com.revature.bank2.BankDriver;
import com.revature.bank2.models.*;
import com.revature.bank2.util.ConnectionFactory;
import com.sun.source.doctree.StartElementTree;

import java.sql.*;
import java.util.*;


public class AccountRepo implements CrudRepository {

    public void save(Account newObj) {

        Connection conn = BankDriver.currentUser().getCurrentSession().getConnection();

        try {
            String sql = "INSERT INTO bank.accounts VALUES (0,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql, new String[]{account_id});
            pstmt.setInt(1, newObj.getId());
            pstmt.setInt(2, newObj.getBalance());
            pstmt.setInt(3, newObj.getUser());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




    public Set<Account> findAll(){

        Connection con = BankDriver.currentUser().getCurrentSession().getConnection();
        Set<Account>  accounts = new HashSet<>();

        try {
            String sql ="Select * FROM bank.accounts WHERE account_id = ?";

        }catch (SQLException e){
            e.printStackTrace();

        }
        return accounts
    }
}

//    public Set<Book> findAll() {
//
//        Connection conn = app().getCurrentSession().getConnection();
//        Set<Book> books = new HashSet<>();
//
//        try {
//
//            String sql = "{CALL rbs_app.get_all_books(?)}";
//            CallableStatement cstmt = conn.prepareCall(sql);
//            cstmt.registerOutParameter(1, OracleTypes.CURSOR);
//            cstmt.execute();
//            books = mapResultSet((ResultSet) cstmt.getObject(1));
//
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return books;
//
//    }


