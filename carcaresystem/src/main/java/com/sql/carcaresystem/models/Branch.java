package com.sql.carcaresystem.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Branch {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer branchID;
    private Integer branchTypeID;
    private String branchName;
    // private String branchAddress;
    private Long branchContact;

    public Integer getBranchID() {
        return branchID;
    }

    public void setBranchID(Integer branchID) {
        this.branchID = branchID;
    }

    public Integer getBranchTypeID() {
        return branchTypeID;
    }

    public void setBranchTypeID(Integer branchTypeID) {
        this.branchTypeID = branchTypeID;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    // public String getBranchAddress() {
    //     return branchAddress;
    // }

    // public void setBranchAddress(String branchAddress) {
    //     this.branchAddress = branchAddress;
    // }

    public Long getBranchContact() {
        return branchContact;
    }

    public void setBranchContact(Long branchContact) {
        this.branchContact = branchContact;
    }

}