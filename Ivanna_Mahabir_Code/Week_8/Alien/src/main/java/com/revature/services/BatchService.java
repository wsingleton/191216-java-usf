package com.revature.services;

import com.revature.models.Batch;
import com.revature.models.EmployeeAssignment;
import com.revature.repos.BatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BatchService {

    @Autowired
    private BatchRepository batchRepo;

    @Autowired
    private EmployeeService employeeService;

    public Mono<Batch> save(Batch batch){return batchRepo.save(batch);}

    public Flux<Batch> findAll(){return batchRepo.findAll();}

    public Mono<Batch> findById(String id){return batchRepo.findById(id);}


    //What are you doing ???????????
    public Flux<Batch> saveAssignment(String emplId){
        Flux.just(emplId).flatMap(employeeService::findById)
        .map(employee -> new EmployeeAssignment[1])
        .log().subscribe();
        return Flux.just();
    }
}
