package com.revature.repos;

import com.revature.models.Accounts;
import com.revature.models.UserAccount;
import com.revature.util.ConnectionFactory;

import java.sql.*;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class UserAccountRepository implements CrudRepository<UserAccount> {


    public Optional<UserAccount> findByCredentials(Integer userId, Integer accountNumber){
        Optional<UserAccount> _userAcct = Optional.empty();

        try(Connection conn = ConnectionFactory.getInstance().getConnection()){
            String sql = "SELECT * FROM accounts WHERE user_id = ? AND accountNumber = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, userId);
            pstmt.setInt(2, accountNumber);

            ResultSet rs = pstmt.executeQuery();
            Set<UserAccount> set = mapResultSet(rs);
            if(!set.isEmpty()) _userAcct = set.stream().findFirst();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return _userAcct;
    }

    public Optional<UserAccount> getAccountByUsername(String username) {
        Optional<UserAccount> _userAccount = Optional.empty();

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

    @Override
    public void save(UserAccount newObj) {

        try(Connection conn = ConnectionFactory.getInstance().getConnection()){
            String sql = "INSERT INTO  VALUES (0, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql, new String[] {"user_id"});
            pstmt.setInt(1, newObj.getUserId());
            pstmt.setInt(2, newObj.getAccountNumber());

            int rowsInserted = pstmt.executeUpdate();

            if(rowsInserted != 0 ){
                ResultSet rs = pstmt.getGeneratedKeys();
                while(rs.next()){
                    newObj.setAccountNumber(rs.getInt(1));

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
    public Set<UserAccount> findAll() {
        return null;
    }

    @Override
    public Optional<UserAccount> findById(Integer user_id) {
        Optional<UserAccount> _userAcct = Optional.empty();

        try(Connection conn = ConnectionFactory.getInstance().getConnection()){
            String sql = "SELECT * FROM  WHERE user_id = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, user_id);

            ResultSet rs = pstmt.executeQuery();
            Set<UserAccount> set = mapResultSet(rs);
            if(!set.isEmpty()){ _userAcct = set.stream().findFirst();}

        }
        catch (SQLException e){
            e.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public Boolean update(UserAccount updatedObj) {
        return null;
    }

    @Override
    public Boolean deleteById(Integer id) {
        return null;
    }

    private Set<UserAccount> mapResultSet(ResultSet rs) throws SQLException{
        Set<UserAccount> userAccts = new HashSet<>();
        while (rs.next()){
            UserAccount temp = new UserAccount();
            temp.setUserId(rs.getInt("user_id"));
            temp.setAccountNumber(rs.getInt("accountNumber"));
            userAccts.add(temp);
        }
        return userAccts;
    }

}
