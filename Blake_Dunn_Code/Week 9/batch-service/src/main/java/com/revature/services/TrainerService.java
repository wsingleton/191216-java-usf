package com.revature.services;

import com.revature.entities.Batch;
import com.revature.entities.Trainer;
import com.revature.repositories.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TrainerService {

    @Autowired
    private TrainerRepository trainerRepo;

    @Autowired
    private BatchService batchService;

    public Flux<Trainer> getAllTrainers() {
        return this.trainerRepo.findAll();
    }

    public Mono<Trainer> save(Trainer trainer) {
        return this.trainerRepo.save(trainer);
    }

    public Mono<Void> deleteById(String id) {
        return this.trainerRepo.deleteById(id);
    }

    public Mono<Trainer> getTrainerById(String id) {
        return this.trainerRepo.findById(id);
    }

}
