package com.revature.patterns;

import com.revature.models.Currency;
import com.revature.models.DodgeCurrency;
import com.revature.models.Dollar;
import com.revature.models.Euro;

public class CurrencyFactory {

    public static Currency printMoney(String country){
        switch (country){
            case "usa":
            case "america":
                return new Dollar();

            case "germany":
            case "europe":
                return new Euro();

            default:
                return new DodgeCurrency();
        }
    }
}
