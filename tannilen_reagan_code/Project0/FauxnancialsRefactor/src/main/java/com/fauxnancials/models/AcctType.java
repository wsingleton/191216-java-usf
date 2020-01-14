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
    public static int getTypeIDByType(AcctType type) {
        int i;
        switch (type) {
            case CHECKING:
                i=1;
                break;
            case SAVINGS:
                i=2;
                break;
            case CD:
                i=3;
                break;
            default:
                i=3;
        }
        return i;
    }

    @Override
    public String toString() {
        return acctType;
    }
}