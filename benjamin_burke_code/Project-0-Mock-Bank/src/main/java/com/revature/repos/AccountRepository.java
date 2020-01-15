package com.revature.repos;

import com.revature.models.Account;
import com.revature.util.ConnectionFactory;

import java.io.IOException;
import java.sql.*;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static com.revature.AppDriver.currentUser;
import static com.revature.AppDriver.router;

public class AccountRepository {

    public double findAccountById(){
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

    public void depositAccountBalance( String da) throws IOException {
        double newBalance;

        newBalance = findAccountById() + Double.parseDouble(da);
        if (newBalance <= 0) {
            System.out.println("You can't deposit negative money! that's withdrawing");

            try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
                String sql = "UPDATE bank_app.accounts SET balance = ? WHERE accountid = ?";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setDouble(1, newBalance);
                pstmt.setString(2, Integer.toString(currentUser.getUsername().hashCode()));
                pstmt.executeUpdate();

            } catch (SQLException e) {

            }
            router.navigate("/balance");
        } else {
            System.out.println("Must only use digits(no more than two numbers after a decimal)");
            router.navigate("/customer");

        }
    }


    public void withdrawAccountBalance(String wa) throws IOException {
        double newBalance;
        newBalance = findAccountById()- Double.parseDouble(wa);
        if(newBalance <0.0){
            System.out.println("You are broke, add funds!");
            router.navigate("/");
        } else {

        }
    }

    public Set<Account> findAllAccounts(){
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

    private Set<Account> mapResultSet(ResultSet rs) throws SQLException{
        Set<Account> acc = new HashSet<>();
        while (rs.next()) {
            Account temp = new Account();
            temp.setAccountId(rs.getString("account_number"));
            temp.setBalance(rs.getDouble("account_balance"));
            acc.add(temp);
        }
        return acc;
    }
}
