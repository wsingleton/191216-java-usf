package com.revature.repos;

import com.revature.models.Account;
import com.revature.util.ConnectionFactory;

import java.sql.*;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static com.revature.BankDriver.currentUser;
import static com.revature.BankDriver.router;

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

    public void increaseAccountBalance(String depositAmount){
        double newBalance;
        if(depositAmount.matches("\\d+(\\.\\d{1,2})?")){
            newBalance = Double.parseDouble(depositAmount) + findAccountBalanceById();
            try(Connection conn = ConnectionFactory.getInstance().getConnection()){
                String sql = "UPDATE bank_app.accounts SET balance = ? WHERE accountid = ?";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setDouble(1, newBalance);
                pstmt.setString(2, Integer.toString(currentUser.getUsername().hashCode()));
                pstmt.executeUpdate();

            }catch(SQLException e){

            }
            router.navigate("/balance");
        }
        else {
            System.out.println("------------------------------");
            System.out.println("Must only use digits(no more than two numbers after a decimal)");
            System.out.println("------------------------------\n");
            router.navigate("/customer");
        }
    }

    public void decreaseAccountBalance(String withdrawAmount){
        double newBalance;
        if(withdrawAmount.matches("\\d+(\\.\\d{1,2})?")){
            newBalance = findAccountBalanceById() - Double.parseDouble(withdrawAmount);
            if(newBalance < 0.0){
                System.out.println("------------------------------");
                System.out.println("Insufficient funds!");
                System.out.println("------------------------------\n");
                router.navigate("/customer");
            }
            else {
                try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
                    String sql = "UPDATE bank_app.accounts SET balance = ? WHERE accountid = ?";
                    PreparedStatement pstmt = conn.prepareStatement(sql);
                    pstmt.setDouble(1, newBalance);
                    pstmt.setString(2, Integer.toString(currentUser.getUsername().hashCode()));
                    pstmt.executeUpdate();

                } catch (SQLException e) {

                }
                router.navigate("/balance");
            }
        }
        else {
            System.out.println("------------------------------");
            System.out.println("Must only use digits(no more than two numbers after a decimal)");
            System.out.println("------------------------------\n");
            router.navigate("/customer");
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
