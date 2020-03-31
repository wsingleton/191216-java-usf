package com.revaturelabs.optimization.trainer;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface TrainerRepository extends ReactiveMongoRepository<Trainer, String> {
}
