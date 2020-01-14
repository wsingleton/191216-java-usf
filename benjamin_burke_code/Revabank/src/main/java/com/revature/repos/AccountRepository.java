package com.revature.repos;

import com.revature.models.Account;
import com.revature.util.ConnectionFactory;

import java.sql.*;
import java.util.*;

import static com.revature.AppDriver.currentUser;

public class AccountRepository implements CrudRepository<Account> {

    public void withdraw(String type, Double amount, int id){
        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String as = " \'" + type + "\'  ";
            String sql = " select * from accounts WHERE user_id =  " + id +" and " + " account_type = " + as;


            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);



            List<Double> list = new ArrayList<>();

            while (rs.next()) {
                list.add(rs.getDouble("account_balance"));
            }

            if(list.get(0) > amount){
                Double newBalance = list.get(0) - amount;



                String sql2 = " UPDATE accounts " +
                        "SET account_balance = " + newBalance +
                        " WHERE user_id =  " + id + " and account_type =  " + as + "  ";

                Statement stmt1 = conn.createStatement();
                stmt1.executeQuery(sql2);

                System.out.println(" you withdrawn  : " + amount +"usd");

                System.out.println("your balance right now is : "+ newBalance +"usd");

            }
            else {
                System.err.println("you dont have enough to withdraw");

            }

        }catch (SQLException e){
            e.printStackTrace();
        }

    }


    public void deposit(String type, Double amount, int id){

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String as = " \'" + type + "\'  ";
            String sql = " select * from accounts WHERE user_id =  " + id +" and " + " account_type = " + as;


            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);



            List<Double> list = new ArrayList<>();

            while (rs.next()) {
                list.add(rs.getDouble("account_balance"));
            }

            Double newBalance = list.get(0) + amount;



            String sql2 = " UPDATE accounts " +
                    "SET account_balance = " + newBalance +
                    " WHERE user_id =  " + id + " and account_type =  " + as + "  ";

            Statement stmt1 = conn.createStatement();
            stmt1.executeQuery(sql2);

            System.out.println(" you deposited : " + amount +"usd");

            System.out.println("your balance right now is : "+ newBalance +"usd");

        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public int isCreatedAccount(Integer id) {
        int i = 0;

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = " select * from accounts WHERE user_id =  " + id +" ";


            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);



            List<String> list = new ArrayList<>();

            while (rs.next()) {
                list.add(rs.getString("account_type"));
            }
            if (list.size() == 2) {
                i = 3;
                return i;
            }

            else {
                for (String s : list) {
                    if (s.equalsIgnoreCase("checking")) {
                        i = 1;
                        return i;
                    } else if (s.equalsIgnoreCase("saving")) {
                        i = 2 ;
                        return i;
                    }
                }
            }


        }catch (SQLException e){
            e.printStackTrace();
        }
        return 0;

    }



    public void save2(Account newObj, int id) {

        try(Connection conn = ConnectionFactory.getInstance().getConnection()){

            String sql = " INSERT INTO accounts VALUES(0,?,?,?)";

            PreparedStatement pstmt = conn.prepareStatement(sql, new String[]{"account_number"});


            pstmt.setString(1, newObj.getAccountType());
            pstmt.setDouble(2, newObj.getBalance());
            pstmt.setInt(3,id);

            int rowsInserted = pstmt.executeUpdate();
            if(rowsInserted != 0){
                ResultSet rs = pstmt.getGeneratedKeys();
                while (rs.next()){
                    newObj.setAccountNumber(rs.getInt(1));
                }
            }



        }catch (SQLIntegrityConstraintViolationException e){
            e.printStackTrace();
        }

        catch (SQLException b){
            b.printStackTrace();
        }

    }

    @Override
    public void save(Account newObj) {

        try(Connection conn = ConnectionFactory.getInstance().getConnection()){

            String sql = " INSERT INTO accounts VALUES(0,?,?,?)";

            PreparedStatement pstmt = conn.prepareStatement(sql, new String[]{"account_number"});


            pstmt.setString(1, newObj.getAccountType());
            pstmt.setDouble(2, newObj.getBalance());
            pstmt.setInt(3,currentUser.getId());

            int rowsInserted = pstmt.executeUpdate();
            if(rowsInserted != 0){
                ResultSet rs = pstmt.getGeneratedKeys();
                while (rs.next()){
                    newObj.setAccountNumber(rs.getInt(1));
                }
            }



        }catch (SQLIntegrityConstraintViolationException e){
            e.printStackTrace();
        }

        catch (SQLException b){
            b.printStackTrace();
        }

    }

    private Set<Account> mapResultSet(ResultSet rs) throws SQLException{
        Set<Account> acc = new HashSet<>();
        while (rs.next()) {
            Account temp = new Account();
            temp.setAccountNumber(rs.getInt("account_number"));
            temp.setAccountType(rs.getString("account_type"));
            temp.setBalance(rs.getDouble("account_balance"));
            acc.add(temp);
        }
        return acc;
    }

    @Override
    public Set<Account> findAll() {
        return null;
    }

    @Override
    public Optional<Account> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public Boolean update(Account updatedObj) {
        return null;
    }

    @Override
    public Boolean deleteById(Integer id) {
        return null;
    }
}
