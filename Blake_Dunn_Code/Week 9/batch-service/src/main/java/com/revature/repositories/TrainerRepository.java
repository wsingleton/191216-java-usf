package com.revature.repositories;

import com.revature.entities.Trainer;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface TrainerRepository extends ReactiveMongoRepository<Trainer, String> {
}
