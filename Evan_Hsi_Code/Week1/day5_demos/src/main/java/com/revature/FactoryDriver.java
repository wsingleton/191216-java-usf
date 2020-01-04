package com.revature;

import com.revature.models.Currency;
import com.revature.patterns.CurrencyFactory;

public class FactoryDriver {
    public static void main(String[] args){
        String country = "";

        country = "USA";
        Currency usa = CurrencyFactory.printMoney(country);
        System.out.println("USA currency symbol: " + usa.getSymbol());

        country = "Germany";
        Currency germany = CurrencyFactory.printMoney(country);
        System.out.println("USA currency symbol: " + germany.getSymbol());

        country = "italy";
        Currency italy = CurrencyFactory.printMoney(country);
        System.out.println("USA currency symbol: " + italy.getSymbol());

        country = "china";
        Currency china = CurrencyFactory.printMoney(country);
        System.out.println("USA currency symbol: " + china.getSymbol());

        country = "Venezuela";
        Currency v = CurrencyFactory.printMoney(country);
        System.out.println("USA currency symbol: " + v.getSymbol());
    }
}
