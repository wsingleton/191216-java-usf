package com.revature.models;

public class Bitcoin implements Currency{
    @Override
    public String getSymbol() {
        return "BTC";
    }
}
