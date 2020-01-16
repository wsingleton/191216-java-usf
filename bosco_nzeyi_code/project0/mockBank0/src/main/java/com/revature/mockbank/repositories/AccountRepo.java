package com.revature.mockbank.repositories;

import com.revature.mockbank.models.*;
import com.revature.mockbank.repositories.CrudRepository;
import com.revature.mockbank.util.ConnectionFactory;
import oracle.jdbc.proxy.annotation.Pre;

import static com.revature.mockbank.AppDriver.*;

import java.sql.*;
import java.util.*;

public class AccountRepo implements CrudRepository<Account> {

    public static Account newAccount;
//    public static Map<Integer, Integer> usersAccounts = new HashMap<>();
        public static ArrayList<Integer> usersAccounts = new ArrayList<>();



    @Override
    public void save(Account data) {
        try(Connection conn = ConnectionFactory.getInstance().getConnection()){

            String sql = "INSERT INTO accounts (account_id) VALUES (?)";

            PreparedStatement ppst = conn.prepareStatement(sql, new String[] {"account_id", "account_type", "account_access", "current_balance"});
            ppst.setInt(1, 0);

            int rowsAffected = ppst.executeUpdate();

            if(rowsAffected != 0){
                ResultSet rs = ppst.getGeneratedKeys();
                data = new Account();
                int newAccountId;
                while(rs.next()){
                    //System.out.println("You new account number is " + rs.getInt(1));

                    data.setAccount_id(rs.getInt(1));
                    data.setAccount_type(rs.getString(2).equals("Checking")? AccountType.CHECKING : AccountType.SAVING);
                    data.setAccount_access(rs.getString(3).equals("Personal")? AccountAccess.PERSONAL: AccountAccess.SHARED);
                    data.setBalance(rs.getInt(4));

                    newAccount = data;
                    newAccountId = rs.getInt(1);
                    //System.out.println(newAccount);

                    String querry = "INSERT INTO users_accounts VALUES(?, ?)";
                    PreparedStatement pst = conn.prepareStatement(querry);
                    pst.setInt(1, currentUser.getId());
                    pst.setInt(2, newAccountId);

                    int rows = pst.executeUpdate();
                    if(rows == 0){
                        System.out.println("An error occurred while matching the user with their accounts");
                    } else{
                        System.out.println("Account and user matched!");
                    }
                }
            }
        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("An error occurred while interacting with the database");
        }
    }

    // find all accounts associated to the user.
        public ArrayList<Integer> findAllAccounts(int userId){
        try(Connection conn = ConnectionFactory.getInstance().getConnection()){

            ArrayList<Integer> accounts = new ArrayList<>();

            String sql = "SELECT account_id FROM users_accounts WHERE user_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, userId);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()){
                accounts.add(rs.getInt(1));
            }
            usersAccounts = accounts;
        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("Connection could not be established");
        }
        listOfAccounts = usersAccounts;
        return usersAccounts;
    }

    public Account findAccountById(Integer id) {
        Account account = new Account();

        try(Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "SELECT * FROM accounts WHERE account_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            account = mapResultSet(rs);
            //currentAccount = account;

        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("CONNECTION COULD NOT BE ESTABLISHED");
        }
        return account;
    }

    @Override
    public Set<Account> findAll() { return null; }

    @Override
    public Optional<Account> findById(Integer id) { return Optional.empty(); }


    @Override
    public Optional<Account> findByUsername(String username) { return Optional.empty(); }

    @Override
    public Boolean update(Integer id) { return null; }

    @Override
    public Boolean delete(Integer id) {
        return null;
    }

    public void deposit (int accountNumber, int userId, double amount){
        String activityType = "Deposit";
        try(Connection conn = ConnectionFactory.getInstance().getConnection()){

            String sql = "{CALL update_balance (?, ?, ?)}";
            CallableStatement cstmt = conn.prepareCall(sql);
            cstmt.setInt(1, accountNumber);
            cstmt.setDouble(2, amount);
            cstmt.setString(3, activityType);

            int rowsInserted = cstmt.executeUpdate();
            if(rowsInserted == 0){
                    System.out.println("Problem performing the operation");
            } else {
                // updating the transaction table with this deposit activity
                updateActivitiesTable(accountNumber, userId, activityType, amount);
                System.out.println("Deposit successful. ... Navigating back to the dashboard");
                // update the balance in the currentAccount in use
                currentAccount.setBalance(currentAccount.getBalance() + amount);
            }

        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("An error occurred while connecting to the database");
        }
    }

    public void withdraw (int accountNumber, int userId, double amount){

        String activityType = "Withdraw";
        try(Connection conn = ConnectionFactory.getInstance().getConnection()){

            String sql = "{CALL update_balance (?, ?, ?)}";
            CallableStatement cstmt = conn.prepareCall(sql);
            cstmt.setInt(1, accountNumber);
            cstmt.setDouble(2, amount);
            cstmt.setString(3, activityType);

            int rowsInserted = cstmt.executeUpdate();
            if(rowsInserted == 0){
                System.out.println("Problem performing the operation");
            }

            // updating the transaction table with this withdraw activity
            updateActivitiesTable(accountNumber, userId, activityType, amount);
            System.out.println("Withdraw successful. ... Navigating back to the dashboard");

            // update the balance in the currentAccount in use
            currentAccount.setBalance(currentAccount.getBalance() - amount);

        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("An error occurred while connecting to the database");
        }
    }

    // check balance

    public void updateActivitiesTable(int accountNumber, int userId, String transactionType, double amount){

        try(Connection conn = ConnectionFactory.getInstance().getConnection()){

            String sql = "INSERT INTO activities (activity_id, user_id, account_id, transaction_details, amount)" +
                    "VALUES(0, ?, ?, ?, ?)";

            PreparedStatement ppstmt = conn.prepareStatement(sql, new String[] {"activity_id"});

            ppstmt.setInt(1, userId);
            ppstmt.setInt(2, accountNumber);
            ppstmt.setString(3, transactionType);
            ppstmt.setDouble(4, amount);

            int rowsInserted = ppstmt.executeUpdate();
            if(rowsInserted != 0){
                ResultSet rs = ppstmt.getGeneratedKeys();
                while(rs.next()){
                    System.out.println("Your new activity id is: " + rs.getInt(1));
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("A problem occurred while inserting into the table [Activities]");
        }
    }

    private Account mapResultSet(ResultSet rs) {

        Account data = new Account();

        try {

            while (rs.next()){

                data.setAccount_id(rs.getInt(1));
                data.setAccount_type(rs.getString(2).equals("Checking")? AccountType.CHECKING : AccountType.SAVING);
                data.setAccount_access(rs.getString(3).equals("Personal")? AccountAccess.PERSONAL: AccountAccess.SHARED);
                data.setBalance(rs.getInt(4));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("COULD NOT MAP ACTIVITIES");
        }
        currentAccount = data;

        return data;

    }
}
