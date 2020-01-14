package com.revature.fauxbankextended.repos;

import com.revature.fauxbankextended.models.Transaction;
import com.revature.fauxbankextended.util.ConnectionFactory;

import java.sql.*;
import java.util.Optional;
import java.util.Set;

import static com.revature.fauxbankextended.BankDriver.app;

public class TransactionRepository implements CrudRepository {

    public Set<Transaction> viewTransactions() {
        return null;
    }
    
    @Override
    public Transaction save(Transaction newTrans) {
        try(Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "INSERT INTO transactions VALUES (0, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql, new String[] {"trans_id"});
            pstmt.setInt(1, app().getCurrentSession().getSessionUser().getId());
            pstmt.setInt(2, app().getCurrentSession().getSessionAccount().getId());
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
        return null;
    }

    @Override
    public Optional findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public Boolean update(Object updateObj) {
        return null;
    }
}
