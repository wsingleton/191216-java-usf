package com.revature.bankapp.repositories;

import com.revature.bankapp.exceptions.AuthorizationException;
import com.revature.bankapp.models.Account;
import com.revature.bankapp.models.TransactionType;
import com.revature.bankapp.models.Type;
import com.revature.bankapp.services.UserService;
import com.revature.bankapp.util.ConnectionFactory;
import oracle.jdbc.proxy.annotation.Pre;

import static com.revature.bankapp.BankDriver.*;

import java.sql.*;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class AccountRepository implements CrudRepository<Account> {

    @Override
    public void save(Account account) {
        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {



            String sql = "INSERT INTO bank_app.accounts VALUES(0, ?, 0.00)";
            PreparedStatement pstmt = conn.prepareStatement(sql, new String[] {"ACCOUNTID"});
            pstmt.setInt(1, account.getType().ordinal() + 1);
            int rowsInserted = pstmt.executeUpdate();

            if(rowsInserted != 0) {
                ResultSet rs = pstmt.getGeneratedKeys();

                while (rs.next()) {
                    account.setAccountid(rs.getInt(1));
                }
            }

            CallableStatement cstmt = conn.prepareCall("{ call junction(?, ?) }");
            cstmt.setInt(1, userid);
            cstmt.setInt(2, account.getAccountid());
            cstmt.executeQuery();

        } catch (SQLException e) { e.printStackTrace(); }
    }

    @Override
    public Set<Account> findAll() {
        Set<Account> accounts = new HashSet<>();

        try(Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "SELECT * FROM bank_app.accounts";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            accounts = mapResultSet(rs);

        } catch (SQLException e) { e.printStackTrace(); }

        return accounts;
    }

    public Set<Account> findAllJoint() {
        Set<Account> accounts = new HashSet<>();

        try(Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "SELECT b.ACCOUNTID, b.TYPE, b.BALANCE FROM bank_app.USERSACCOUNTS a " +
                    "JOIN bank_app.ACCOUNTS b ON b.ACCOUNTID = a.ACCOUNTID " +
                    "JOIN bank_app.USERS c ON a.USERID = c.USERID " +
                    "WHERE b.ACCOUNTID NOT IN (SELECT ACCOUNTID FROM bank_app.USERSACCOUNTS GROUP BY ACCOUNTID HAVING COUNT(ACCOUNTID) = 1) AND a.USERID = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, userid);
            ResultSet rs = pstmt.executeQuery();

            accounts = mapResultSet(rs);

        } catch (SQLException e) { e.printStackTrace(); }

        return accounts;

    }

    public void addUserToAccount(String un, String pw, int id) {

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
            System.out.println("IM IN");
            String sql = "SELECT * FROM USERS WHERE USERNAME = ? AND PASSWORD = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, un);
            pstmt.setInt(2, pw.hashCode());
            int rows = pstmt.executeUpdate();
            System.out.println(rows);
            if(rows != 1) {
                System.out.println("Invalid User");
                return;
            }
            else {
                ResultSet rs = pstmt.executeQuery();
                int uID = 0;
                while(rs.next()) {
                    uID = rs.getInt("USERID");
                }
                String put = "INSERT INTO USERSACCOUNTS VALUES(?, ?)";
                PreparedStatement ps = conn.prepareStatement(put);
                ps.setInt(1, uID);
                ps.setInt(2, id);
                ps.executeQuery();

            }

        } catch ( SQLException e) {e.printStackTrace();}
    }

    @Override
    public Optional<Account> findById(int id) {
        return Optional.empty();
    }

    public Set<Account> findByUser(int id) {
        Set<Account> accounts = new HashSet<>();

        try(Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "SELECT * FROM bank_app.ACCOUNTS " +
                    "JOIN bank_app.USERSACCOUNTS " +
                    "USING (ACCOUNTID) " +
                    "WHERE USERID = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            accounts = mapResultSet(rs);

        } catch (SQLException e) { e.printStackTrace(); }

        return accounts;
    }

    @Override
    public boolean update(Account account) {
        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "UPDATE bank_app.accounts WHERE ACCOUNTID = ? SET BALANCE = ?, TYPE = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, account.getAccountid());
            pstmt.setDouble(2, account.getBalance());
            pstmt.setInt(3, account.getType().ordinal() + 1);

            int rowsUpdated = pstmt.executeUpdate();

        } catch (SQLException e) { e.printStackTrace(); return false; }
        return true;
    }

    public boolean owner(int id) {
        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "SELECT ACCOUNTID FROM bank_app.USERSACCOUNTS WHERE USERID = ? AND ACCOUNTID = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, userid);
            pstmt.setInt(2, id);

            int rows = pstmt.executeUpdate();

            if(rows != 1) return false;

        } catch (SQLException e) { e.printStackTrace(); }
        return true;
    }

    @Override
    public boolean deleteById(int id) {
        try(Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "DELETE FROM USERSACCOUNTS WHERE ACCOUNTID = ? AND USERID = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.setInt(2, userid);
            pstmt.execute();

            String call = "DELETE FROM ACCOUNTS WHERE ACCOUNTID NOT IN (SELECT DISTINCT ACCOUNTID FROM USERSACCOUNTS)";
            PreparedStatement cstmt = conn.prepareStatement(call);
            //cstmt.setInt(1, id);
            cstmt.execute();

        } catch (SQLException | AuthorizationException e) {e.printStackTrace(); }
        return true;
    }

    public void deposit(int id, double amount) {
        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "UPDATE bank_app.ACCOUNTS SET BALANCE = BALANCE + ? WHERE ACCOUNTID = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setDouble(1, amount);
            pstmt.setInt(2, id);
            pstmt.executeQuery();

        } catch (SQLException e) { e.printStackTrace(); }
    }

    public boolean withdraw(int id, double amount) {
        double balance = 0;
        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
            String get = "SELECT BALANCE FROM bank_app.ACCOUNTS WHERE ACCOUNTID = ?";


            PreparedStatement stmt = conn.prepareStatement(get);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();


            while(rs.next()) {
                balance = rs.getDouble("balance");
            }
            if(balance > amount) {
                String sql = "{call WITHDRAWCHECK(?, ?)}";
                CallableStatement cstmt = conn.prepareCall(sql);
                cstmt.setInt(1, id);
                cstmt.setDouble(2, amount);
                cstmt.execute();
                return true;
            }
            else {
                System.out.println("Insufficient Funds");
                return false;
            }

        } catch (SQLException e) { e.printStackTrace(); }
        return false;
    }

    private Set<Account> mapResultSet(ResultSet rs) throws SQLException {

        Set<Account> users = new HashSet<>();

        while(rs.next()) {
            Account temp = new Account();
            temp.setAccountid(rs.getInt("accountid"));
            temp.setBalance(rs.getDouble("balance"));
            temp.setType(Type.getTypeByID(rs.getInt("type")));    //come back to this
            users.add(temp);
        }
        return users;
    }
}
