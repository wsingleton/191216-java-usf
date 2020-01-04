package com.revature;

import com.revature.models.Currency;
import com.revature.patterns.CurrencyFactory;

public class FactoryDriver {

    public static void main (String[] args){

        String country;

        country = "usa";
        Currency US = CurrencyFactory.printMoney(country);
        System.out.println("USA currency symbol: " + US.getSymbol());

        country = "Italy";
        Currency Italy = CurrencyFactory.printMoney(country);
        System.out.println("Italy currency is: " + Italy.getSymbol());

    }
}
