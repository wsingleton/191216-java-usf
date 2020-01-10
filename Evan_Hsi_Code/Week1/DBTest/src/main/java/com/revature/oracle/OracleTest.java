package com.revature.oracle;

import java.sql.*;

public class OracleTest {

    public static void main(String[] args) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) { e.printStackTrace(); }
        Connection conn = null;
        try {
            //String url = "jdbc:oracle:thin:@localhost:11521:xe";
            String url = "jdbc:oracle:thin:@revature.clnscuumfo9c.us-east-2.rds.amazonaws.com:1521:ORCL";

            //conn = DriverManager.getConnection(url, "admin", "deucalion13");
            conn = DriverManager.getConnection(url, "chinook", "p4ssw0rd");
            //conn = DriverManager.getConnection(url, "sys as sysdba", "testing12345");
            //conn = DriverManager.getConnection(url, "ot", "helpme");

            if(conn != null) {
                System.out.println("Connected");
            }
        }
        catch (SQLException sqle) { System.out.println(sqle.getMessage()); }

        /*
        PreparedStatement ps;
            try {
                ps = conn.prepareStatement("CREATE TABLE");
            }
            catch(SQLException sqle) {
                System.out.println(sqle.getMessage());
            }
         */
    }
}
