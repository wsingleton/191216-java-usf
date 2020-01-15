package com.revature.repos;

import com.revature.models.Account;
import com.revature.util.ConnectionFactory;

import java.sql.*;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static com.revature.BankDriver.currentUser;

public class AccountRepository {

    public double findAccountBalanceById() {
        Optional<Account> _account = Optional.empty();
        final double[] balance = new double[1];

        try(Connection conn = ConnectionFactory.getInstance().getConnection()){
            String sql = "SELECT * FROM bank_app.accounts WHERE accountid = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, Integer.toString(currentUser.getUsername().hashCode()));
            ResultSet rs = pstmt.executeQuery();
            Set<Account> set = mapResultSet(rs);
            if(!set.isEmpty()) _account = set.stream().findFirst();

        }catch(SQLException e){

        }
        _account.ifPresent(account -> {
            balance[0] = account.getBalance();
        });

        return balance[0];
    }

    public void increaseAccountBalance(double depositAmount){
                try(Connection conn = ConnectionFactory.getInstance().getConnection()){
                String sql = "UPDATE bank_app.accounts SET balance = ? WHERE accountid = ?";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setDouble(1, depositAmount);
                pstmt.setString(2, Integer.toString(currentUser.getUsername().hashCode()));
                pstmt.executeUpdate();

            }catch(SQLException e){

            }
    }

    public void decreaseAccountBalance(double withdrawAmount){

                try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
                    String sql = "UPDATE bank_app.accounts SET balance = ? WHERE accountid = ?";
                    PreparedStatement pstmt = conn.prepareStatement(sql);
                    pstmt.setDouble(1, withdrawAmount);
                    pstmt.setString(2, Integer.toString(currentUser.getUsername().hashCode()));
                    pstmt.executeUpdate();

                } catch (SQLException e) {

                }
    }


    //a method that uses a statement
    public Set<Account> findAllAccounts() {

        Set<Account> accounts = new HashSet<>();

        try (Connection conn = ConnectionFactory.getInstance().getConnection()){
            String sql = "SELECT * FROM bank_app.accounts";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            accounts = mapResultSet(rs);
        }
        catch (SQLException e){
            e.printStackTrace();
        }

        return accounts;
    }


    //maps through result set(places the account into a set).
    private Set<Account> mapResultSet(ResultSet rs) throws SQLException {
        Set<Account> account = new HashSet<>();
        while (rs.next()) {
            Account temp = new Account();
            temp.setId(rs.getString("accountid"));
            temp.setBalance(rs.getDouble("balance"));
            account.add(temp);
        }

        return account;
    }
}
