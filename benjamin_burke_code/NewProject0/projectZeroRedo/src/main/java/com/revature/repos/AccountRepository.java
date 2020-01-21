package com.revature.repos;

import com.revature.models.Accounts;
import com.revature.models.UserAccount;
import com.revature.util.ConnectionFactory;

import java.sql.*;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static com.revature.AppDriver.app;

public class AccountRepository implements CrudRepository<Accounts> {

    public Optional<Accounts> findAccountByUsername(String username){
        Optional<Accounts> _acct = Optional.empty();

        try(Connection conn = ConnectionFactory.getInstance().getConnection()){
            String sql = "SELECT * FROM accounts WHERE accountNumber = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);

            ResultSet rs = pstmt.executeQuery();
            Set<Accounts> set = mapResultSet(rs);
            if(!set.isEmpty()){_acct = set.stream().findFirst();}

        }
        catch (SQLException e){
            e.printStackTrace();
        }

        return _acct;
    }

    public Optional<Accounts> getAccountByUsername(String username) {
        Optional<Accounts> _userAccount = Optional.empty();

        try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
            String sql = "SELECT * FROM accounts WHERE account_user = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);

            ResultSet rs = pstmt.executeQuery();
            _userAccount = mapResultSet(rs).stream().findFirst();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return _userAccount;
    }

// le's idea to move the save from sevices to repo
    public void save2(Accounts newObj, String username) {

        try(Connection conn = ConnectionFactory.getInstance().getConnection()){
            String sql = "INSERT INTO accounts VALUES (0, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql, new String[] {"accountnumber"});



            pstmt.setDouble(1, newObj.getBalance());
            pstmt.setString(2, username);

            int rowsInserted = pstmt.executeUpdate();

            if(rowsInserted != 0 ){
                ResultSet rs = pstmt.getGeneratedKeys();
                while(rs.next()){
                    newObj.setAccountNumber(rs.getInt(1));

                }
            }
        }
//        catch (SQLIntegrityConstraintViolationException e){
//            e.printStackTrace();
//        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
    @Override
    public void save(Accounts newObj) {

        try(Connection conn = ConnectionFactory.getInstance().getConnection()){
            String sql = "INSERT INTO accounts VALUES (0, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql, new String[] {"accountnumber"});



            pstmt.setDouble(1, newObj.getBalance());
            pstmt.setString(2, app().getCurrentSession().getSessionUser().getUsername());

            int rowsInserted = pstmt.executeUpdate();

            if(rowsInserted != 0 ){
                ResultSet rs = pstmt.getGeneratedKeys();
                while(rs.next()){
                    newObj.setAccountNumber(rs.getInt(1));

                }
            }
        }
//        catch (SQLIntegrityConstraintViolationException e){
//            e.printStackTrace();
//        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Set<Accounts> findAll() {
        return null;
    }

    @Override
    public Optional<Accounts> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public Boolean update(Accounts updatedObj) {
        Connection conn = app().getCurrentSession().getConnection();
        boolean updateSuccessful = false;

        try {

            String sql = "UPDATE accounts SET balance = ?" + "WHERE accountnumber = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setDouble(1, updatedObj.getBalance());
            pstmt.setInt(2, updatedObj.getAccountNumber() );

            int rowsUpdated = pstmt.executeUpdate();

            if (rowsUpdated > 0) {
                updateSuccessful = true;
            }

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return updateSuccessful;
    }

    @Override
    public Boolean deleteById(Integer id) {
        return null;
    }

//    public void deposit( Double amount){
//    try (Connection conn = ConnectionFactory.getInstance().getConnection()){
//        String sql = "update  set balance = ? where accountNumber = ?";
//        PreparedStatement pstmt = conn.prepareStatement(sql);
//        pstmt.setDouble(1, amount);
//        pstmt.executeUpdate();
//    } catch (SQLException e){
//
//    }
//
//}
//
//public void withdraw(double amount){
//    try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
//        String sql = "update set balance = ? where accountNumber = ? ";
//        PreparedStatement pstmt = conn.prepareStatement(sql);
//        pstmt.setDouble(1, amount);
//        pstmt.executeUpdate();
//    } catch (SQLException e){
//
//    }
//}

//    public Optional<Accounts> updateAccount(Integer accountNumber, Double balance){
//        Optional<Accounts> _acct = Optional.empty();
//        if(balance < 0){ balance=0.0;}
//        try(Connection conn = ConnectionFactory.getInstance().getConnection()){
//            String sql = "UPDATE accounts SET balance =" + balance+ "WHERE  = ?";
//
//            PreparedStatement pstmt = conn.prepareStatement(sql);
//            pstmt.setDouble(1, balance);
//
//            ResultSet rs = pstmt.executeQuery();
//
//        }
//        catch (SQLException e){
//            e.printStackTrace();
//        }
//
//        return _acct;
//    }

private Set<Accounts> mapResultSet(ResultSet rs) throws SQLException {
    Set<Accounts> accounts = new HashSet<>();
    while (rs.next()){
        Accounts temp = new Accounts();
        temp.setAccountNumber(rs.getInt("accountNumber"));
        temp.setBalance(rs.getDouble("balance"));
        accounts.add(temp);
    }
    return accounts;
}


}
