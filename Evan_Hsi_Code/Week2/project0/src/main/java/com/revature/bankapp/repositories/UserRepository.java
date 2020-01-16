package com.revature.bankapp.repositories;

import com.revature.bankapp.models.Role;
import com.revature.bankapp.models.User;
import com.revature.bankapp.util.ConnectionFactory;
import static com.revature.bankapp.BankDriver.*;

import java.sql.*;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class UserRepository implements CrudRepository<User> {
    @Override
    public void save(User user) {
        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "INSERT INTO bank_app.users VALUES (0, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql, new String[] {"userid"});
            pstmt.setString(1, user.getFirstName());
            pstmt.setString(2, user.getLastName());
            pstmt.setString(3, user.getUserName());
            pstmt.setInt(4, user.getPassWord());
            pstmt.setInt(5, user.getRole().ordinal() + 1);
            int rowsInserted = pstmt.executeUpdate();

            if (rowsInserted != 0) {

                ResultSet rs = pstmt.getGeneratedKeys();

                while (rs.next()) {
                    user.setId(rs.getInt(1));
                }
            }

        } catch (SQLIntegrityConstraintViolationException e) { e.printStackTrace(); }
        catch (SQLException e) { e.printStackTrace(); }
    }

    @Override
    public Set<User> findAll() {
        Set<User> users = new HashSet<>();

        try(Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "SELECT * FROM bank_app.users";

            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            users = mapResultSet(rs);


        } catch(SQLException e) { e.printStackTrace(); }

        return users;
    }

    @Override
    public Optional<User> findById(int id) {
        return Optional.empty();
    }

    @Override
    public boolean update(User user) {
        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "UPDATE bank_app.users WHERE USER_ID = ? SET FIRSTNAME = ?, LASTNAME = ?, " +
                    "USERNAME = ?, PASSWORD = ?, ROLE = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, user.getId());
            pstmt.setString(2, user.getFirstName());
            pstmt.setString(3, user.getLastName());
            pstmt.setString(4, user.getUserName());
            pstmt.setInt(5, user.getPassWord());
            pstmt.setInt(6, user.getRole().ordinal() + 1);

            int rowsUpdated = pstmt.executeUpdate();
            if(rowsUpdated == 1) return true;
            else return false;

        } catch (SQLException e) { e.printStackTrace(); }
        return false;
    }

    @Override
    public boolean deleteById(int id) {
        try (Connection conn = ConnectionFactory.getInstance().getConnection()){
            String sql = "DELETE FROM USERS WHERE USERID=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();

            System.out.println("Deleted successfully");
        } catch (SQLException e) { e.printStackTrace(); return false;}
        return true;
    }

    public boolean deleteOwn() {
        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "DELETE FROM USERS WHERE USERID = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, userid);
            pstmt.executeUpdate();

            System.out.println("Deleted Successfully. Goodbye.");

        } catch (SQLException e) { e.printStackTrace(); return false; }
        return true;
    }

    public Set<User> findUsersByRole(Role role) {
        return null;
    }

    public Optional<User> findUserByUserName(String username) {
         Optional<User> _user = Optional.empty();

         try( Connection conn = ConnectionFactory.getInstance().getConnection()) {

             String sql = "SELECT * FROM bank_app.users WHERE username = ?";
             PreparedStatement pstmt = conn.prepareStatement(sql);
             pstmt.setString(1, username);
             ResultSet rs = pstmt.executeQuery();
             Set<User> users = mapResultSet(rs);
             if(!users.isEmpty()) _user = users.stream().findFirst();

         } catch (SQLException e) { e.printStackTrace(); }

         return _user;
    }

    public Optional<User> findUserByCredentials(String username, String pw) {

        Optional<User> _user = Optional.empty();

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "SELECT * FROM bank_app.users WHERE username = ? AND password = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setInt(2, pw.hashCode());

            ResultSet rs = pstmt.executeQuery();
            Set<User> users = mapResultSet(rs);
            if(!users.isEmpty()) _user = users.stream().findFirst();

        } catch (SQLException e) { e.printStackTrace(); }

        return _user;
    }

    private Set<User> mapResultSet(ResultSet rs) throws SQLException {

        Set<User> users = new HashSet<>();

        while(rs.next()) {
            User temp = new User();
            temp.setId(rs.getInt("userid"));
            temp.setUserName(rs.getString("username"));
            temp.setPassWord(rs.getInt("password"));
            temp.setFirstName(rs.getString("firstname"));
            temp.setLastName(rs.getString("lastname"));
            temp.setRole(Role.getRoleByID(rs.getInt("type")));    //come back to this
            users.add(temp);
        }

        return users;

    }
}
