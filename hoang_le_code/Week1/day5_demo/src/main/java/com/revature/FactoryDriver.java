package com.revature;

import com.revature.models.Currency;
import com.revature.pattems.CurrencyFactory;

public class FactoryDriver {
    public static void main(String[] args){
        String country;
        country = "usa";
        Currency dollar = CurrencyFactory.printMoney(country);
        System.out.println("us dollar currency symbol : " + dollar.getSymbol());


        country = "italy";
        Currency italy = CurrencyFactory.printMoney(country);
        System.out.println("italy dollar currency symbol : " + italy.getSymbol());


        country = "germany";
        Currency germa = CurrencyFactory.printMoney(country);
        System.out.println("Germany dollar currency symbol : " + germa.getSymbol());


        country = "china";
        Currency china = CurrencyFactory.printMoney(country);
        System.out.println("china dollar currency symbol : " + china.getSymbol());


        country = "vietnam";
        Currency vietnam = CurrencyFactory.printMoney(country);
        System.out.println("vietnam dollar currency symbol : " + vietnam.getSymbol());
    }
}
