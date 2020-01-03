package com.revature;

import com.revature.models.Currency;
import com.revature.patterns.CurrencyFactory;

public class FactoryDriver {

    public static void main(String[] args) {

        String country;

        country = "USA";
        Currency dollar = CurrencyFactory.printMoney(country);
        System.out.println("US Dollar currency symbol: " + dollar.getSymbol());

        country = "Italy";
        Currency italy = CurrencyFactory.printMoney(country);
        System.out.println("Italy currency symbol: " + italy.getSymbol());

        country = "Germany";
        Currency germany = CurrencyFactory.printMoney(country);
        System.out.println("Germany currency symbol: " + germany.getSymbol());

        country = "France";
        Currency france = CurrencyFactory.printMoney(country);
        System.out.println("France currency symbol: " + france.getSymbol());

        country = "China";
        Currency china = CurrencyFactory.printMoney(country);
        System.out.println("China currency symbol: " + china.getSymbol());

        country = "Venezuela";
        Currency venezuela = CurrencyFactory.printMoney(country);
        System.out.println("Venezuela currency symbol: " + venezuela.getSymbol());

    }
}
