package com.revature.oracle;

import java.sql.*;

public class OracleTest {

    public static void main(String[] args) {
        //Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection conn = null;
        try {
            //String url = "jdbc:oracle:thin:@localhost:11521/~/Documents/docker-images/OracleDatabase/SingleInstance/dockerfiles/18.4.0/dockerfiles_oracle_1";
            //String url = "jdbc:oracle:thin:OT/orcl1234@xepdb1:11521:xe";
            String url = "jdbc:oracle:thin:@localhost:11521:xe";
            conn = DriverManager.getConnection(url, "sys as sysdba", "testing12345");
            //conn = DriverManager.getConnection(url, "OT", "ORCL1234");
        }
        catch (SQLException sqle) { System.out.println(sqle.getMessage()); }

        PreparedStatement ps;
            try {
                ps = conn.prepareStatement("CREATE TABLE");
            }
            catch(SQLException sqle) {
                System.out.println(sqle.getMessage());
            }
    }
}
