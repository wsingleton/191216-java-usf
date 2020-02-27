package com.revature.web.controllers;

import com.revature.entities.Trainer;
import com.revature.services.BatchService;
import com.revature.services.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/trainer")
public class TrainerController {

    @Autowired
    TrainerService trainerService;

    @Autowired
    BatchService batchService;

    @GetMapping
    public Flux<Trainer> getAllTrainers() {
        return trainerService.getAllTrainers();
    }

    
}
