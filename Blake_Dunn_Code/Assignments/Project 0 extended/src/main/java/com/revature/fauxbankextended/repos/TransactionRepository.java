package com.revature.fauxbankextended.repos;

import com.revature.fauxbankextended.models.Transaction;
import com.revature.fauxbankextended.models.TransactionType;

import java.sql.*;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static com.revature.fauxbankextended.BankDriver.app;

public class TransactionRepository implements CrudRepository<Transaction> {

    public Set<Transaction> getCurrentAccountTransactionsHistory() {
        Connection conn = app().getCurrentSession().getConnection();

        Set<Transaction> transHistory = new HashSet<>();

        try{
            String sql = "SELECT user_id, acct_id, trans_type_id, amount, " +
                    "trans_date " +
                    " FROM transactions WHERE acct_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql, new String[] {"user_id", "acct_id", "trans_type_id", "amount", "trans_date"});
            pstmt.setInt(1, app().getCurrentSession().getSessionAccount().getId());
            transHistory = mapResultSet(pstmt.executeQuery());
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return transHistory;
    }

    @Override
    public Transaction save(Transaction newTrans) {
        Connection conn = app().getCurrentSession().getConnection();
        try {

            String sql = "INSERT INTO transactions (trans_id, user_id, acct_id, trans_type_id, amount) " +
                    " VALUES (0, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql, new String[] {"trans_id"});
            pstmt.setInt(1, newTrans.getUserId());
            pstmt.setInt(2, newTrans.getAcctId());
            pstmt.setInt(3, newTrans.getType().ordinal() +1);
            pstmt.setDouble(4, newTrans.getAmount());

            int rowsInserted = pstmt.executeUpdate();

            if (rowsInserted != 0) {
                ResultSet rs = pstmt.getGeneratedKeys();

                while(rs.next()) {
                    newTrans.setTransId(rs.getInt(1));
                }
            }

        } catch(SQLIntegrityConstraintViolationException e) {
            e.printStackTrace();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return newTrans;
    }

    @Override
    public Optional findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public Boolean update(Transaction updateObj) {
        return null;
    }

    private Set<Transaction> mapResultSet(ResultSet rs) throws SQLException {
        Set<Transaction> transactions = new HashSet<>();
        while (rs.next()) {
            Transaction temp = new Transaction();
            temp.setUserId(rs.getInt("user_id"));
            temp.setAcctId(rs.getInt("acct_id"));
            temp.setType(TransactionType.getTransactionTypeById(rs.getInt("trans_type_id")));
            temp.setAmount(rs.getDouble("amount"));
            temp.setDate(rs.getString("trans_date"));
            transactions.add(temp);
        }
        return transactions;
    }
}
