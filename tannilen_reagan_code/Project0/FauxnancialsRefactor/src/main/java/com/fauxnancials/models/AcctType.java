package com.fauxnancials.models;

public enum AcctType {
    CHECKING("checking"), SAVINGS("savings"), CD("c.d.");
    private String acctType;

    AcctType(String acctType) {
        this.acctType = acctType;
    }

    public static AcctType getAcctTypeById(int i) {
        AcctType type=null;
        switch (i) {
            case 1:
                type=AcctType.CHECKING;
                break;
            case 2:
                type=AcctType.SAVINGS;
                break;
            default:
                type=AcctType.CD;
                break;
        }
        return type;
    }

    @Override
    public String toString() {
        return acctType;
    }
}