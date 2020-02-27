package com.revature.repositories;

import com.revature.entities.Batch;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;


public interface BatchRepository extends ReactiveMongoRepository<Batch, String> {
}
