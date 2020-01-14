package com.revature.mockbank.models;

import com.revature.mockbank.exceptions.InvalidRequestException;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class Account {

    private int account_id;
    private AccountType account_type;
    private AccountAccess account_access;
    private Date date_opened;
    private Double balance;
    private ArrayList<String> accountHistory = new ArrayList<>();

    public Account() {
        super();
    }
}
