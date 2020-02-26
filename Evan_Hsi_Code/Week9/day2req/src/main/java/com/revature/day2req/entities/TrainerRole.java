package com.revature.day2req.entities;

import lombok.Data;
import lombok.NoArgsConstructor;


public enum TrainerRole {
    TRAINER(1, "Trainer"), QC(2, "QC");

    private int id;
    private String roleName;

    TrainerRole() {

    }

    TrainerRole(int id, String roleName) {
        this.id = id;
        this.roleName = roleName;
    }

    public static TrainerRole getById(int id) {
        for (TrainerRole role : TrainerRole.values()) {
            if (role.id == id) {
                return role;
            }
        }
        return TrainerRole.TRAINER;
    }
}
