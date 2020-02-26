package com.revature.day2req;

import com.revature.day2req.entities.Batch;
import com.revature.day2req.entities.Trainer;
import com.revature.day2req.entities.TrainerAssignment;
import com.revature.day2req.entities.TrainerRole;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Driver {

    public static void main(String[] args) {

        //Create Batch
        Batch batch = new Batch(1, "191216JAVAUSF", new Date(2019, 12, 16), new Date(2020, 3, 20), new ArrayList<TrainerAssignment>());

        //Create Trainers
        Trainer trainer1 = new Trainer(1, "Wezley", "Singleton", TrainerRole.TRAINER);
        Trainer trainer2 = new Trainer(2, "Quintin", "Donnelly", TrainerRole.TRAINER);
        Trainer trainer3 = new Trainer(3, "Jonathan", "????", TrainerRole.QC);

        //Create TrainerAssignments
        TrainerAssignment ta1 = new TrainerAssignment(trainer1, new Date(2019, 12, 16), new Date(2020, 3, 20));
        TrainerAssignment ta2 = new TrainerAssignment(trainer2, new Date(2020, 2, 24), new Date(2020, 2, 28));
        TrainerAssignment ta3 = new TrainerAssignment(trainer3, new Date(2020, 1, 1), new Date(2020, 3, 20));
        TrainerAssignment ta4 = new TrainerAssignment(trainer3, new Date(2030, 1, 1), new Date(2030, 4, 1));

        //Add TrainerAssignments to batch and print a boolean
        // indicating whether the operation was successful
        System.out.println(batch.addTrainerAssignment(ta1));
        System.out.println(batch.addTrainerAssignment(ta2));
        System.out.println(batch.addTrainerAssignment(ta3));

        //fails due to invalid dates
        System.out.println(batch.addTrainerAssignment(ta4));

        //Confirming all trainer assignments have been added
        System.out.println(batch.getTrainerAssignmentList());
    }
}
