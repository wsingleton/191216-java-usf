package com.fauxnancials.repos;

import com.fauxnancials.models.Acct;
import com.fauxnancials.models.AcctType;
import com.fauxnancials.util.ConnectionFactory;

import java.sql.*;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class AccountRepository implements CrudRepository<Acct> {
    public Set<Acct> findByOwner(int id) {
        Set<Acct> accts = new HashSet<>();

        try (Connection conn=ConnectionFactory.getInstance().getConnection()) {
            String sql = "SELECT * FROM fauxnancials_admin.accounts WHERE user_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,id);
            ResultSet rs = pstmt.executeQuery();
            accts = mapResultSet(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accts;
    }
    @Override
    public void save(Acct acct) {
        try (Connection conn=ConnectionFactory.getInstance().getConnection()) {
            String sql="insert into fauxnancials_admin.accts values (0, ?, ?, ?)";
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1, AcctType.getTypeIDByType(acct.getAcctType()));
            pstmt.setDouble(2,acct.getBalance());
            pstmt.setInt(3,acct.getUserID());
            int rowsInserted=pstmt.executeUpdate();
        }
        catch (SQLIntegrityConstraintViolationException e) {
            e.printStackTrace();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public Optional<Acct> findByID(Integer id) {
        return Optional.empty();
    }
    @Override
    public boolean update(Acct acct) {
        return false;
    }
    @Override
    public boolean deleteByID(Integer id) {
        return false;
    }
    private Set<Acct> mapResultSet(ResultSet rs) throws SQLException {
        Set<Acct> accts = new HashSet<>();
        while (rs.next()) {
            Acct temp=new Acct();
            temp.setAcctID(rs.getInt("acct_id"));
            temp.setAcctType(AcctType.getAcctTypeById(rs.getInt("type_id")));
            temp.setBalance(rs.getDouble("acct_bal"));
            temp.setUserID(rs.getInt("user_id"));
            accts.add(temp);
        }
        return accts;
    }
}