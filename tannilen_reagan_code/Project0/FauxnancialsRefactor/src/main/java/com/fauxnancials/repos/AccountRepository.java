package com.fauxnancials.repos;

import com.fauxnancials.exceptions.ResourcePersistenceException;
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
            String sql="{call saveAcct(0, ?, ?, ?, ?)}";
            CallableStatement cstmt=conn.prepareCall(sql);
            cstmt.setInt(1, AcctType.getTypeIDByType(acct.getAcctType()));
            cstmt.setDouble(2,acct.getBalance());
            cstmt.setInt(3, acct.getUserID());
            cstmt.registerOutParameter(4, Types.NUMERIC);
            cstmt.executeUpdate();
            int updExecuted=cstmt.getInt(4);
            if (updExecuted==0) {
                throw new ResourcePersistenceException();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        catch (ResourcePersistenceException ex) {
            System.err.println("Account creation failed.  Please visit your local branch office or try again later.");
        }
    }
    @Override
    public Optional<Acct> findByID(Integer id) {
        Optional<Acct> acct = Optional.empty();
        try (Connection conn= ConnectionFactory.getInstance().getConnection()) {
            String sql="SELECT * FROM fauxnancials_admin.accounts WHERE acct_id=?";
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,id);
            ResultSet rs = pstmt.executeQuery();
            Set<Acct> accts= mapResultSet(rs);
            if (!accts.isEmpty()) {
                acct=accts.stream().findFirst();
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return acct;
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
            Acct temp = new Acct();
            temp.setAcctID(rs.getInt("acct_id"));
            temp.setAcctType(AcctType.getAcctTypeById(rs.getInt("type_id")));
            temp.setBalance(rs.getDouble("acct_bal"));
            temp.setUserID(rs.getInt("user_id"));
            accts.add(temp);
        }
        return accts;
    }
    public Set<Acct> getAllAccts() {
        Set<Acct> accts = new HashSet<>();

        try (Connection conn=ConnectionFactory.getInstance().getConnection()) {
            String sql = "SELECT * FROM fauxnancials_admin.accounts";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            accts = mapResultSet(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accts;
    }
}