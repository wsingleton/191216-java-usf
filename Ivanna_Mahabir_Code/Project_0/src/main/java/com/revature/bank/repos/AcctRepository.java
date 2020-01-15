package com.revature.bank.repos;

import com.revature.bank.models.Account;
import com.revature.bank.models.User;
import com.revature.bank.util.ConnectionFactory;


import java.sql.*;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class AcctRepository implements CrudRepository<Account> {

/*    public void newAcct(Account newObj){

        try(Connection conn = ConnectionFactory.getInstance().getConnection()){
            String sql = "INSERT INTO CBANK.accts VALUES (0, ?, 0.0)";
            PreparedStatement pstmt = conn.prepareStatement(sql, new String[] {"acct_user"});
            pstmt.setString(2, newObj.getUsername());


            int rowsInserted = pstmt.executeUpdate();
            if(rowsInserted != 0 ){
                ResultSet rs = pstmt.getGeneratedKeys();
                while(rs.next()){
                    newObj.setAcctId(rs.getInt(1));
                    newObj.setUsername(rs.getString(2));
                    newObj.setBalance(0.0);

                }
            }
        }


        catch (SQLIntegrityConstraintViolationException e){
            e.printStackTrace();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }*/

    public Optional<Account> findAcctByUsername(String username){
        Optional<Account> _acct = Optional.empty();

        try(Connection conn = ConnectionFactory.getInstance().getConnection()){
            String sql = "SELECT * FROM CBANK.accts WHERE user_name = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            Set<Account> set = mapResultSet(rs);
            if(!set.isEmpty()) _acct = set.stream().findFirst();
        }
        catch (SQLException e){
            e.printStackTrace();
        }

        return _acct;
    }

    @Override
    public void save(Account newObj) {
        try(Connection conn = ConnectionFactory.getInstance().getConnection()){
            String sql = "INSERT INTO CBANK.accts VALUES (0, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql, new String[] {"acctid"});
            pstmt.setString(2, newObj.getUsername());
            pstmt.setDouble(3, newObj.getBalance());

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
            temp.setUsername(rs.getString("username"));
            temp.setBalance(rs.getDouble("balance"));
            accts.add(temp);
        }

        return accts;
    }
}
