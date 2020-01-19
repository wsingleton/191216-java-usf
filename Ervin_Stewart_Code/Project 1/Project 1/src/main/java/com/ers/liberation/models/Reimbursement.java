package com.ers.liberation.models;

import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.Blob;
import java.sql.Date;
import java.sql.Timestamp;

public class Reimbursement {

    private Integer reimbId;
    private Double amount;
    private Timestamp submitted;
    private Timestamp resolved;
    private String description;
    private File receipt;
    private ReimbursementStatus status;
    private ReimbursementType type;



}
