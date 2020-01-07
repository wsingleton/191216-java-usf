package com.revature.patterns;

import com.revature.models.*;

public class CurrecyFactory {

    public static Currency printMoney(String country){
        switch (country.toLowerCase()){
            case "usa":
            case "america":
                return new Dollar();
            case "germany":
            case "italy":
                return new Euros();
            case "china":
                return new Yuan();
            default:
                return new Dogecoin();
        }
    }
}
