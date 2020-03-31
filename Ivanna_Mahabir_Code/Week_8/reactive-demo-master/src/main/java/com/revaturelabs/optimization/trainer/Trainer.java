package com.revaturelabs.optimization.trainer;

import com.revaturelabs.optimization.batch.Batch;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Trainer {
  @Id
  String id;
  String firstName;
  String lastName;
}
