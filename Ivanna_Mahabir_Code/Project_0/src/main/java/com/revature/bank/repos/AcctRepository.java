package com.revature.bank.repos;

import com.revature.bank.models.Account;
import com.revature.bank.util.ConnectionFactory;


import java.sql.*;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class AcctRepository implements CrudRepository<Account> {
    @Override
    public void save(Account newObj) {
        try(Connection conn = ConnectionFactory.getInstance().getConnection()){
            String sql = "INSERT INTO CBANK.accts VALUES (0, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql, new String[] {"acctid"});
            pstmt.setDouble(2, newObj.getBalance());

            int rowsInserted = pstmt.executeUpdate();
            if(rowsInserted != 0 ){
                ResultSet rs = pstmt.getGeneratedKeys();
                while(rs.next()){
                    newObj.setAcctId(1);
                }
            }
        }
        catch (SQLIntegrityConstraintViolationException e){
            e.printStackTrace();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Set<Account> findAll() {
        return null;
    }

    @Override
    public Optional<Account> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public Boolean update(Account updateObj) {
        return null;
    }

    private Set<Account> mapResultSet(ResultSet rs) throws SQLException {
        Set<Account> accts = new HashSet<>();
        while(rs.next()){
            Account temp = new Account();
            temp.setAcctId(rs.getInt("acctid"));
            temp.setBalance(rs.getDouble("balance"));
            accts.add(temp);
        }

        return accts;
    }
}
