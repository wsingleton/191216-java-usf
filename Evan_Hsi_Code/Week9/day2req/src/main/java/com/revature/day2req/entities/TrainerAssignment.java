package com.revature.day2req.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrainerAssignment {
    private Trainer trainer;
    private Date startDate;
    private Date endDate;
}
