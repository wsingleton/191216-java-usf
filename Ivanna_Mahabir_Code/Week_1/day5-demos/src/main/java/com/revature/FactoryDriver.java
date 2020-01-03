package com.revature;

import com.revature.models.Currency;
import com.revature.patterns.CurrencyFactory;

public class FactoryDriver {
    public static void main(String[] args){

        String country;
        country = "USA";
        Currency dollar = CurrencyFactory.printMoney(country);
        System.out.println("US Dollar currency symbol: " + dollar.getSymbol());

        country = "Italy";
        Currency italy = CurrencyFactory.printMoney(country);
        System.out.println("Italy Dollar currency symbol: " + italy.getSymbol());

        country = "Germany";
        Currency germany = CurrencyFactory.printMoney(country);
        System.out.println("Germany Dollar currency symbol: " + germany.getSymbol());

        country = "China";
        Currency china = CurrencyFactory.printMoney(country);
        System.out.println("China Dollar currency symbol: " + china.getSymbol());

        country = "Venezuela";
        Currency venezuela = CurrencyFactory.printMoney(country);
        System.out.println("Venezuela Dollar currency symbol: " + venezuela.getSymbol());
    }

}
