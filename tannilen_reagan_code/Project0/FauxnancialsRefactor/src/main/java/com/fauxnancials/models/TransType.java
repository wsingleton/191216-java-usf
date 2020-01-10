package com.fauxnancials.models;

public enum TransType {
    DEPOSIT("deposit"), WITHDRAWAL("withdrawal"), TRANSFER("transfer");
    private String transType;

    TransType(String transType) {
        this.transType = transType;
    }

    public static TransType getTransTypeById(int i) {
        TransType type=null;
        switch (i) {
            case 1:
                type=TransType.DEPOSIT;
                break;
            case 2:
                type=TransType.WITHDRAWAL;
                break;
            default:
                type=TransType.TRANSFER;
                break;
        }
        return type;
    }

    @Override
    public String toString() {
        return transType;
    }
}