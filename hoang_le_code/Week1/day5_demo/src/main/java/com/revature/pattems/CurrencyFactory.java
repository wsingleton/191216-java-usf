package com.revature.pattems;

import com.revature.models.*;

public class CurrencyFactory {
    public static Currency printMoney(String country){
        switch (country.toLowerCase()){
            case "usa":
            case "america":
                return new Dollar();
            case "germany":
            case  "italy":
            case "France":
                return new Euro();
            case "china":
                return new Yuan();
            default:
                return new Dogecoin();

        }
    }
}
