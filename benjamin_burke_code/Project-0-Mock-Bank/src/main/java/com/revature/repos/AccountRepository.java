package com.revature.repos;

import com.revature.models.Account;
import com.revature.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    public void withdrawAccountBalance(String wa){
        double newBalance;
        newBalance = findAccountById()- Double.parseDouble(wa);
        if(newBalance <0.0){
            System.out.println("You are broke, add funds!");
            router.navigate("/");
        } else {

        }
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
