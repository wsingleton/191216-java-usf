package com.revature.patterns;

import com.revature.models.*;

public class CurrencyFactory {

    public static Currency printMoney(String country) {

        switch (country.toLowerCase()) {

            case "usa":
            case "america":
                return new Dollar();
            case "germany":
            case "italy":
            case "france":
                return new Euro();
            case "china":
                return new Yuan();
            default:
                return new Dogecoin();

        }
    }

}
