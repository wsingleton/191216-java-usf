package com.revature.services;

import com.revature.entities.Batch;
import com.revature.entities.TrainerAssignment;
import com.revature.repositories.BatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BatchService {

    @Autowired
    private BatchRepository batchRepo;

    @Autowired
    private TrainerService trainerService;

    public Flux<Batch> findAll() {
        return batchRepo.findAll();
    }

    public Mono<Batch> save(Batch batch) {
        return batchRepo.save(batch);
    }

    public Mono<Batch> findById(String id) {
        return batchRepo.findById(id);
    }

    public Mono<Void> delete(String id) {
        return batchRepo.deleteById(id);
    }

//    public Flux<Batch> saveAssignments(String trainerId) {
//        Flux.just(trainerId).flatMap(trainerService::getTrainerById)
//                .map(trainer -> new TrainerAssignment("trainer", trainer))
//                .log().subscribe(thing -> thing.getRole());
//
//        return Flux.just();
//    }
}
