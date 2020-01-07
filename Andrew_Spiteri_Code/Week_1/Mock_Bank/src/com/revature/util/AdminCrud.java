package com.revature.util;

import com.revature.models.Account;
import com.revature.models.AccountType;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import static com.revature.util.ConnectionFactory.*;

public class AdminCrud {

    public static Boolean createAccountTypeTable(){
        Connection con = createConnection();
        try {
            Statement st = con.createStatement();
            String sql = "INSERT INTO ACCOUNT_TYPE VALUES (1," + AccountType.SAVINGS.name() +")";
            int x = st.executeUpdate(sql);
            if(x >= 1){
                return true;
            }
        }catch (SQLException sqlE){
            sqlE.getSQLState();
        }
        return false;
    }
}
