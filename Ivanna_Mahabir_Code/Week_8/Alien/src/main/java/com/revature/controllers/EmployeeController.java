package com.revature.controllers;

import com.revature.models.Batch;
import com.revature.services.BatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
public class EmployeeController {

    @Autowired
    private BatchService batchService;

    @GetMapping
    public Flux<Batch> getAllBatches(){
        batchService.saveAssignment("5");
        return batchService.findAll();
    }
}
