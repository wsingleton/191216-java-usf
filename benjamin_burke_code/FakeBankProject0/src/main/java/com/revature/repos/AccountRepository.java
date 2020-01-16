package com.revature.repos;

import com.revature.models.Account;
import com.revature.models.User;
import com.revature.util.ConnectionFactory;

import java.sql.*;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class AccountRepository implements CrudRepository<Account>{

    public Optional<Account>findByUsername(String username) throws SQLException {
        Optional<Account> account = Optional.empty();

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
            String sql = "SELECT * FROM accounts WHERE username = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);

            ResultSet rs = pstmt.executeQuery();
            account = mapResultSet(rs).stream().findFirst();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return account;
    }

    @Override
    public void save(Account newObj){
        try(Connection conn = ConnectionFactory.getInstance().getConnection()){
            String sql ="INSERT INTO accounts VALUES(0,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql, new String[]{"accountId"});
            pstmt.setDouble(1, newObj.getBalance());
            int rowsInserted = pstmt.executeUpdate();

            if (rowsInserted !=0){
                ResultSet rs = pstmt.getGeneratedKeys();

                while (rs.next()){
                    newObj.setAccountId(rs.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public Set<Account> findAll(){
        Set<Account> accounts = new HashSet<>();
        try(Connection conn = ConnectionFactory.getInstance().getConnection()){

            String sql = " SELECT * FROM accounts";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            accounts = mapResultSet(rs);

        }catch (SQLException e){
            e.printStackTrace();
        }

        return accounts;
    }

    @Override
    public Optional<Account> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public Boolean update(Account updatedObj){
        boolean updated = false;

        try(Connection conn = ConnectionFactory.getInstance().getConnection()){


            String sql = "UPDATE accounts SET balance = ? WHERE accountId = ?";
            PreparedStatement pstmt= conn.prepareStatement(sql);
            pstmt.setInt(1, updatedObj.getAccountId());
            pstmt.setDouble(2, updatedObj.getBalance());

            int rowUpdated = pstmt.executeUpdate();

            if(rowUpdated>0){
                updated = true;
            }
        } catch (SQLException e){
            e.printStackTrace();
        }

        return updated;
    }

    @Override
    public Boolean deleteById(Integer id) {
        return null;
    }

    private Set<Account> mapResultSet(ResultSet rs) throws SQLException{
        Set<Account> acc = new HashSet<>();
        while (rs.next()) {
            Account temp = new Account();
            temp.setAccountId(rs.getInt("accountId"));
            temp.setBalance(rs.getDouble("balance"));
            acc.add(temp);
        }
        return acc;
    }
    }

