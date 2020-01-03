package com.revature;

import com.revature.models.Currency;
import com.revature.patterns.CurrencyFactory;

public class FactoryDriver {
    public static void main(String[] args) {
String country;
country= "USA";
        Currency dollar = CurrencyFactory.printMoney(country);
        System.out.println("US ddollar currency symbol: " + dollar.getSymbol());

        country = "euro";
        Currency euro = CurrencyFactory.printMoney(country);
        System.out.println("euro dollar symbol: " + euro.getSymbol());

    }
}
