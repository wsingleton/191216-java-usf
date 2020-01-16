package com.revature.bankapp.services;

import com.revature.bankapp.models.Transaction;
import com.revature.bankapp.repositories.TransactionRepository;

import java.util.Set;

public class TransactionService {

    private TransactionRepository transactionRepository;

    public TransactionService() {

    }

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public Set<Transaction> findAll() {
        return transactionRepository.findAll();
    }

    public Set<Transaction> findByID(int id) {
        return transactionRepository.findByAccount(id);
    }
}
