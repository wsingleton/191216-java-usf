package com.revature;

import com.revature.models.Currency;
import com.revature.patterns.CurrencyFactory;

public class FactoryDriver {
    public static void main(String[] args) {
        String country;
        country="United StatEs";
        Currency dollas= CurrencyFactory.printMoney(country);
        System.out.println("United States currency: " + dollas.getSymbol());
        country="Australia";
        Currency australia= CurrencyFactory.printMoney(country);
        System.out.println("Australia currency: " + australia.getSymbol());
        country="japan";
        Currency nipon= CurrencyFactory.printMoney(country);
        System.out.println("Japan currency: " + nipon.getSymbol());
        country="malta";
        Currency malta= CurrencyFactory.printMoney(country);
        System.out.println("Sovereign Military Order of Malta currency: " + malta.getSymbol());
    }
}
