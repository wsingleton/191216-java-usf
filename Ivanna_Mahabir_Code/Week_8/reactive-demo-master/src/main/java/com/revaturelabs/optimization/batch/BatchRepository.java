package com.revaturelabs.optimization.batch;

import com.revaturelabs.optimization.trainer.Trainer;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface BatchRepository extends ReactiveMongoRepository<Batch, String> {

}
