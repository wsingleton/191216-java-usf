package com.lynda.common.service;

import com.lynda.common.aspect.Loggable;
import com.lynda.common.data.entity.Customer;
import com.lynda.common.data.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Loggable
    public List<Customer> getAll(){
        return (List<Customer>) this.customerRepository.findAll();
    }

    @Loggable
    public Customer findOne(String id){
        return this.customerRepository.findOne(id);
    }
}
