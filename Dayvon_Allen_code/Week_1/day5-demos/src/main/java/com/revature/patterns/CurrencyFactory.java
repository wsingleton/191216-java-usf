package com.revature.patterns;

import com.revature.models.*;

public class CurrencyFactory {

    public static Currency printMoney(String country) {
        switch (country.toLowerCase()){

            case "usa":
            case "america":
                return  new Dollar();
            case "germany":
            case "france":
            case "italy":
                return new Euro();
            case "japan":
                return new Yen();
            default:
                return new Pound();
        }
    }



}
