package com.revature.patterns;

import com.revature.models.Currency;
import com.revature.models.Dollar;
import com.revature.models.Euro;

public class CurrencyFactory {

    public static Currency printMoney(String country){

        switch (country.toLowerCase()){

            case "usa";
            case "america";
                return new Dollar();

             case "germany";
             case "france";
                return new Euro();
        }
    }
}
