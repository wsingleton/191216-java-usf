package com.revature.mockbank.repositories;

import com.revature.mockbank.models.TransactionHistory;
import com.revature.mockbank.util.ConnectionFactory;
import static com.revature.mockbank.AppDriver.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class TransactionRepo implements CrudRepository <TransactionHistory> {
    public static Set<TransactionHistory> log;

    @Override
    public void save(TransactionHistory data) {
    }

    @Override
    public Set<TransactionHistory> findAll() {
        return null;
    }
    @Override
    public Optional<TransactionHistory> findById(Integer id) {
        return Optional.empty();
    }

    public Set<TransactionHistory> findActivityById(Integer id) {

        Set<TransactionHistory> hist = new HashSet<>();

        try(Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "SELECT * FROM activities WHERE user_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            hist = mapResultSet(rs);
            log = hist;

        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("CONNECTION COULD NOT BE ESTABLISHED");
        }
        return hist;

    }

    private Set<TransactionHistory> mapResultSet(ResultSet rs) {

        Set<TransactionHistory> activities = new HashSet<>();

        try {

            while (rs.next()){
                TransactionHistory transaction = new TransactionHistory();
              transaction.setActivityId(rs.getInt(1));
              transaction.setUserId(rs.getInt(2));
              transaction.setAccountId(rs.getInt(3));
              transaction.setActivityDate(rs.getString(4));
              transaction.setTransactionDetails(rs.getString(5));
              transaction.setAmount(rs.getDouble(6));

              activities.add(transaction);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("COULD NOT MAP ACTIVITIES");
        }

        return activities;

    }

    @Override
    public Optional<TransactionHistory> findByUsername(String username) {
        return Optional.empty();
    }

    @Override
    public Boolean update(Integer id) {
        return null;
    }

    @Override
    public Boolean delete(Integer id) {
        return null;
    }
}
