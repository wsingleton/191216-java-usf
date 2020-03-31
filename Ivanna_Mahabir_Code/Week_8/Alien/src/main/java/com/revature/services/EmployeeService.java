package com.revature.services;



import com.revature.models.Employee;
import com.revature.repos.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepo;

    @Autowired
    private BatchService batchService;

    public Mono<Employee> save(Employee emp){return employeeRepo.save(emp);}

    public Flux<Employee> findAll(){return employeeRepo.findAll();}

    public Mono<Employee> findById(String id){return employeeRepo.findById(id);}

}
