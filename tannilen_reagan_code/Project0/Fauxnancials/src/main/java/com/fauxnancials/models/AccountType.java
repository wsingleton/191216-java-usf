package com.fauxnancials.models;

public enum AccountType {
    CHECKING("checking"), SAVINGS("savings"), CD("C.D."), BOND("savings bond");
    private String acctType;
    AccountType(String acctType) {this.acctType=acctType;}
    @Override
    public String toString() {return acctType;}
}
