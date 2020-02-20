package com.revature.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@SequenceGenerator(name="vendor_gen", sequenceName="vendor_seq", allocationSize=1)
public class  Vendor {

    @Id
    @Column
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="vendor_gen")
    private int id;

    @JoinColumn(nullable=false)
    @OneToOne(cascade=CascadeType.ALL)
    private User user;

    @Enumerated(EnumType.STRING)
    @Column
    private TentType tent;

    @Enumerated(EnumType.STRING)
    @Column
    private VendorType type;

    @Column(nullable=false)
    private String details;

    @Column
    private String companyName;

    @Enumerated(EnumType.STRING)
    @Column
    private ApplicationStatus status;

    public Vendor() {
        super();
    }

    public Vendor(User user, VendorType type, String details) {
        this.user = user;
        this.type = type;
        this.details = details;
    }

    public Vendor(User user, VendorType type, String details, String companyName) {
        this.user = user;
        this.type = type;
        this.details = details;
        this.companyName = companyName;
    }

    public TentType getTent() {
        return tent;
    }

    public void setTent(TentType tent) {
        this.tent = tent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public VendorType getType() {
        return type;
    }

    public void setType(VendorType type) {
        this.type = type;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public ApplicationStatus getStatus() {
        return status;
    }

    public void setStatus(ApplicationStatus status) {
        this.status = status;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vendor vendor = (Vendor) o;
        return id == vendor.id &&
                Objects.equals(user, vendor.user) &&
                tent == vendor.tent &&
                type == vendor.type &&
                Objects.equals(details, vendor.details) &&
                Objects.equals(companyName, vendor.companyName) &&
                status == vendor.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, tent, type, details, companyName, status);
    }

    @Override
    public String toString() {
        return "Vendor{" +
                "id=" + id +
                ", user=" + user +
                ", tent=" + tent +
                ", type=" + type +
                ", details='" + details + '\'' +
                ", companyName='" + companyName + '\'' +
                ", status=" + status +
                '}';
    }
}
