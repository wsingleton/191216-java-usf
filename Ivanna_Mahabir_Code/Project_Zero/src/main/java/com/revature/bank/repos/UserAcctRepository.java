package com.revature.bank.repos;

import com.revature.bank.models.Account;
import com.revature.bank.models.UserAcct;
import com.revature.bank.util.ConnectionFactory;

import java.sql.*;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class UserAcctRepository implements CrudRepository<UserAcct> {

    public Optional<UserAcct> findByCredentials(Integer userId, Integer acctId){
        Optional<UserAcct> _userAcct = Optional.empty();

        try(Connection conn = ConnectionFactory.getInstance().getConnection()){
            String sql = "SELECT * FROM CBANK.useracct WHERE user_id = ? AND acct_id = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, userId);
            pstmt.setInt(2, acctId);

            ResultSet rs = pstmt.executeQuery();
            Set<UserAcct> set = mapResultSet(rs);
            if(!set.isEmpty()) _userAcct = set.stream().findFirst();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return _userAcct;
    }

    public void newUserAcct(UserAcct newObj){
        Optional<UserAcct> _userAcct = Optional.empty();
        String sql = "INSERT INTO CBANK.useracct VALUES (?, ?)";

        try(Connection conn = ConnectionFactory.getInstance().getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ) {
            pstmt.setInt(1, newObj.getUser_id());
            pstmt.setInt(2, newObj.getAcct_id());

            ResultSet rs = pstmt.executeQuery();
            Set<UserAcct> set = mapResultSet(rs);
            if(!set.isEmpty()) _userAcct = set.stream().findFirst();
        }
        catch (SQLException e){
            e.printStackTrace();
        }

    }

    @Override
    public void save(UserAcct newObj) {

        try(Connection conn = ConnectionFactory.getInstance().getConnection()){
            String sql = "INSERT INTO CBANK.useracct VALUES (0, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql, new String[] {"user_id"});
            pstmt.setInt(1, newObj.getUser_id());
            pstmt.setInt(2, newObj.getAcct_id());

            int rowsInserted = pstmt.executeUpdate();

            if(rowsInserted != 0 ){
                ResultSet rs = pstmt.getGeneratedKeys();
                while(rs.next()){
                    newObj.setAcct_id(rs.getInt(1));

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
    public Set findAll() {
        return null;
    }

    @Override
    public Optional<UserAcct> findById(Integer user_id) {
        Optional<UserAcct> _userAcct = Optional.empty();

        try(Connection conn = ConnectionFactory.getInstance().getConnection()){
            String sql = "SELECT * FROM CBANK.useracct WHERE user_id = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, user_id);

            ResultSet rs = pstmt.executeQuery();
            Set<UserAcct> set = mapResultSet(rs);
            if(!set.isEmpty()){_userAcct = set.stream().findFirst();}

        }
        catch (SQLException e){
            e.printStackTrace();
        }

        return Optional.empty();
    }

    private Set<UserAcct> mapResultSet(ResultSet rs) throws SQLException{
        Set<UserAcct> userAccts = new HashSet<>();
        while (rs.next()){
            UserAcct temp = new UserAcct();
            temp.setAcct_id(rs.getInt("user_id"));
            temp.setAcct_id(rs.getInt("acct_id"));
            userAccts.add(temp);
        }
        return userAccts;
    }

    @Override
    public Boolean update(UserAcct updateObj) {
        return null;
    }


}
