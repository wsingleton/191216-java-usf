package com.ers.liberation.models;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Date;
import java.sql.Timestamp;

public class Reimbursement {

    private Integer reimbId;
    private Double amount;
    private Timestamp submittedDate;
    private Timestamp resolvedDate;
    private String description;
    private InputStream receipt;
    private Integer AuthorId;
    private Integer resolverId;
    private ReimbursementStatus status;
    private ReimbursementType type;



}
