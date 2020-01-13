package com.revature.repos;



public interface BankActionRepository<T> {
    void save(T newObj);
}
