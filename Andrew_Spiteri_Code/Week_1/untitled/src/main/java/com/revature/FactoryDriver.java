package com.revature;

import com.revature.models.Currency;
import com.revature.patterns.CurrecyFactory;

public class FactoryDriver {


    public static void main(String[] args) {
        String country;

        country = "usa";
        Currency dollar = CurrecyFactory.printMoney(country);
        System.out.println("US Dollar currency symbol: " + dollar.getSymbol());

        country = "Italy";
        Currency euro = CurrecyFactory.printMoney(country);
        System.out.println("Italian currency symbol: " + euro.getSymbol());

        country = "China";
        Currency yuan = CurrecyFactory.printMoney(country);
        System.out.println("Chinese currency symbol: " + yuan.getSymbol());

        country = "Venezuela";
        Currency venezuela = CurrecyFactory.printMoney(country);
        System.out.println("Venezuelan currency symbol: " + venezuela.getSymbol());
    }
}
