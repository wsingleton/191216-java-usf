package com.revature.repos;

import com.revature.models.Batch;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface BatchRepository extends ReactiveMongoRepository<Batch, String> {
}
