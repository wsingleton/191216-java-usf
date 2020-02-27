package com.revature.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.Set;

@Data
@Document
@AllArgsConstructor
@NoArgsConstructor
public class Batch {

    @Id
    String id;
    @NotBlank
    String name;
    LocalDate startDate;
    LocalDate endDate;
    Set<TrainerAssignment> trainerAssignments;
}
