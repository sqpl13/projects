package com.sql.carcaresystem.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Staff {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer staffID;
    private Integer staffTypeID;
    private String staffName;
    private Integer branchID;
    @Lob
    private String staffDetails;
    private Boolean is_deleted;
    
    public Integer getStaffID() {
        return staffID;
    }

    public void setStaffID(Integer staffID) {
        this.staffID = staffID;
    }

    public Integer getStaffTypeID() {
        return staffTypeID;
    }

    public void setStaffTypeID(Integer staffTypeID) {
        this.staffTypeID = staffTypeID;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public Integer getBranchID() {
        return branchID;
    }

    public void setBranchID(Integer branchID) {
        this.branchID = branchID;
    }

    public String getStaffDetails() {
        return staffDetails;
    }

    public void setStaffDetails(String staffDetails) {
        this.staffDetails = staffDetails;
    }

    public Boolean getIs_Deleted() {
        return is_deleted;
    }

    public void setIs_Deleted(Boolean is_deleted) {
        this.is_deleted = is_deleted;
    }

}
