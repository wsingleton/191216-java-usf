package com.revaturelabs.optimization.trainer;

import com.revaturelabs.optimization.batch.Batch;
import com.revaturelabs.optimization.batch.BatchService;
import com.revaturelabs.optimization.batch.TrainerAssignment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TrainerService {
  @Autowired
  TrainerRepository trainerRepository;

  @Autowired
  BatchService batchService;

  public Flux<Trainer> getAllTrainers() {
    return this.trainerRepository.findAll();
  }

//  public Flux<Batch> getAllBatchesForTrainer(String trainerId) {
//    return batchService.findAllByTrainerId(trainerId);
//  }

  public Mono<Trainer> save(Trainer trainer) {
    return this.trainerRepository.save(trainer);
  }

  public Mono<Void> deleteById(String id) {
    return this.trainerRepository.deleteById(id);
  }

  public Mono<Trainer> getTrainerById(String id) {
    return this.trainerRepository.findById(id);
  }
}
