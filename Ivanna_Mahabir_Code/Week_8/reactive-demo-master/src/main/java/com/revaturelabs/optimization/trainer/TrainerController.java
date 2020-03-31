package com.revaturelabs.optimization.trainer;

import com.revaturelabs.optimization.batch.Batch;
import com.revaturelabs.optimization.batch.BatchService;
import com.revaturelabs.optimization.batch.TrainerAssignment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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

  @PostMapping
  public Mono<Trainer> createTrainer(@RequestBody Trainer trainer) {
    return trainerService.save(trainer);
  }

  @GetMapping("{id}")
  public Mono<Trainer> getTrainerById(@PathVariable String id) {
    return trainerService.getTrainerById(id);
  }

//  @GetMapping("{id}/batches")
//  public Flux<Batch> getAllBatchesForTrainer(@PathVariable String id) {
//    return trainerService.getAllBatchesForTrainer(id);
//  }

  @DeleteMapping("{id}")
  public Mono<Void> deleteTrainerById(@PathVariable String id) {
    return trainerService.deleteById(id);
  }
}
