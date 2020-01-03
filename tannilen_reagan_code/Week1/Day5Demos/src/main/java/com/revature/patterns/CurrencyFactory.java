package com.revature.patterns;

import com.revature.models.*;

public class CurrencyFactory {
    public static Currency printMoney(String country) {
        switch (country.toLowerCase()) {
            case "america":
            case "usa":
            case "united states":
                return new USD();
            case "australia":
                return new AUD();
            case "japan":
                return new Yen();
            default:
                return new Bitcoin();
        }
    }
}
