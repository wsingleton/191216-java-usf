package com.revature;

import com.revature.models.Currency;
import com.revature.patterns.CurrencyFactory;

public class FactoryDriver {

    public static void main(String[] args) {
        String country;
        country = "USA";

        Currency dollar = CurrencyFactory.printMoney(country);
        System.out.println("US dollar currency symbol is " + dollar.getSymbol());

        country = "germany";

        Currency euro = CurrencyFactory.printMoney(country);
        System.out.println("Germany's currency symbol is " + euro.getSymbol());

        country = "Japan";

        Currency yen = CurrencyFactory.printMoney(country);
        System.out.println("Japanese yen currency symbol is " + yen.getSymbol());

        country = "britain";

        Currency pound = CurrencyFactory.printMoney(country);
        System.out.println("Britain's currency symbol is " + pound.getSymbol());
    }

}
