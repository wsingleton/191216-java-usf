package com.revature.repos;

import java.util.Optional;
import java.util.Set;

public interface BankActionRepository<T> {
    void save(T newObj);
    Boolean update(T updatedObj);
}
