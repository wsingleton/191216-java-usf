package com.revaturelabs.optimization.batch;

import com.revaturelabs.optimization.trainer.Trainer;
import com.revaturelabs.optimization.trainer.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BatchService {

  @Autowired
  private BatchRepository batchRepository;

  @Autowired
  private TrainerService trainerService;

  public Mono<Batch> save(Batch batch) {
    return batchRepository.save(batch);
  }

  public Flux<Batch> findAll() {
    return batchRepository.findAll();
  }

  public Mono<Batch> findById(String id) {
    return batchRepository.findById(id);
  }

  public Flux<Batch> saveAssignments(String trainerId) {
    Flux.just(trainerId).flatMap(trainerService::getTrainerById)
    .map(trainer -> new TrainerAssignment("trainer", trainer))
    .log().subscribe(thing -> thing.getRole());

    return Flux.just();
  }

  public Mono<Void> delete(String id) {
    return batchRepository.deleteById(id);
  }

}
