package com.revature.bankapp.repositories;

import com.revature.bankapp.models.Role;
import com.revature.bankapp.models.Transaction;
import com.revature.bankapp.models.TransactionType;
import com.revature.bankapp.models.User;
import com.revature.bankapp.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class TransactionRepository implements CrudRepository<Transaction> {
    @Override
    public void save(Transaction transaction) {

    }

    @Override
    public Set<Transaction> findAll() {
        Set<Transaction> allset = new HashSet<>();
        try(Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "SELECT * FROM TRANSACTIONS";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            allset = mapResultSet(rs);

        } catch (SQLException e) { e.printStackTrace(); }
         return allset;
    }

    @Override
    public Optional<Transaction> findById(int id) {
        Optional<Transaction> _transaction = Optional.empty();
        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "SELECT * FROM TRANSACTIONS WHERE TRANSACTIONID = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            _transaction = mapResultSet(rs).stream().findFirst();

        }
        catch(SQLException e) { e.printStackTrace(); return Optional.empty(); }
        return _transaction;
    }

    public Set<Transaction> findByAccount(int id) {
        Set<Transaction> allset = new HashSet<>();
        System.out.println("check3");
        try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
            System.out.println("check4");
            String sql = "SELECT * FROM TRANSACTIONS WHERE ACCOUNTID = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            System.out.println("check5");
            allset = mapResultSet(rs);

        } catch (SQLException e) { e.printStackTrace(); }
        return allset;
    }

    public Set<Transaction> findByUser(int id) {
        Set<Transaction> allset = new HashSet<>();
        try(Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "SELECT ACCOUNTID, BALANCE, TRANSACTIONAMOUNT, TRANSACTIONTYPE, TRANSACTIONDATE " +
                    "FROM ACCOUNTS JOIN USERSACCOUNTS USING (ACCOUNTID) " +
                    "JOIN TRANSACTIONS USING (ACCOUNTID) WHERE USERID = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            allset = mapResultSet(rs);

        } catch (SQLException e) { e.printStackTrace(); }
        return allset;
    }

    @Override
    public boolean update(Transaction transaction) {
        return false;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }

    private Set<Transaction> mapResultSet(ResultSet rs) throws SQLException {

        Set<Transaction> transactions = new HashSet<>();

        while (rs.next()) {
            Transaction temp = new Transaction();
            temp.setTransactionid(rs.getInt("TRANSACTIONID"));
            temp.setAccountid(rs.getInt("ACCOUNTID"));
            temp.setDate(rs.getString("TRANSACTIONDATE"));
            temp.setAmount(rs.getDouble("TRANSACTIONAMOUNT"));
            temp.setType(TransactionType.getTransactionTypeByID(rs.getInt("TRANSACTIONTYPE")));    //come back to this
            transactions.add(temp);
        }

        return transactions;
    }

}
