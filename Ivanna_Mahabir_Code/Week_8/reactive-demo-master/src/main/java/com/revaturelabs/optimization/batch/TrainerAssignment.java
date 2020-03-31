package com.revaturelabs.optimization.batch;

import com.revaturelabs.optimization.trainer.Trainer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrainerAssignment {
  @NotBlank
  String role;
  @DBRef
  Trainer trainer;
}
