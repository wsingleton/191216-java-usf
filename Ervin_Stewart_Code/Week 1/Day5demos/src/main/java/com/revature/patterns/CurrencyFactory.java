package com.revature.patterns;

import com.revature.models.Currency;
import com.revature.models.Dogecoin;
import com.revature.models.Dollar;

public class CurrencyFactory {
    public static Currency printMoney(String country){

        switch (country.toLowerCase()){
            case "usa":
                case "america":
                        return new Dollar();
            default:
                return new Dogecoin();
        }

    }
}
