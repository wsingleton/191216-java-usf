package com.revature.day2req.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Trainer {
    private int id;
    private String firstName;
    private String lastName;
    private TrainerRole role;
}
