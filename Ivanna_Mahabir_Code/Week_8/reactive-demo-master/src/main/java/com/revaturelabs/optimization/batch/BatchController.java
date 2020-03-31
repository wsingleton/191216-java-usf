package com.revaturelabs.optimization.batch;

import com.revaturelabs.optimization.trainer.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping("/batch")
public class BatchController {

  @Autowired
  private BatchService batchService;

  @GetMapping
  public Flux<Batch> getAllBatches() {
    batchService.saveAssignments("5e502e5a5d07443c6b7aa530");
    return batchService.findAll();
  }

  @PostMapping
  public Mono<Batch> saveBatch(@RequestBody Batch batch) {
    return batchService.save(batch).log();
  }

  @GetMapping("/{id}")
  public Mono<Batch> getBatchById(@PathVariable String id) {
    return batchService.findById(id);
  }

  @PutMapping("/{id}")
  public Mono<Batch> updateOrCreateBatch(@PathVariable String id, @Valid @RequestBody Batch batch) {
    return batchService.save(batch);
  }

  @DeleteMapping("/{id}")
  public Mono<Void> deleteBatchById(@PathVariable String id) {
    return batchService.delete(id);
  }
}
