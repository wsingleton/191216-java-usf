package com.revature.day2req.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Batch {
    private int id;
    private String name;
    private Date startDate;
    private Date endDate;
    private ArrayList<TrainerAssignment> trainerAssignmentList = new ArrayList<>();

    public boolean addTrainerAssignment(TrainerAssignment trainerAssignment) {
        if(trainerAssignment.getEndDate().before(trainerAssignment.getStartDate()) ||
                trainerAssignment.getStartDate().before(this.startDate) ||
                trainerAssignment.getEndDate().after(this.endDate)) return false;
        else {
            trainerAssignmentList.add(trainerAssignment);
            return true;
        }
    }
}
