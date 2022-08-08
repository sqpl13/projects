package com.sql.carcaresystem.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="booking")
public class Booking {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer bookingID;
    @Column(name = "guestName")
    @NotBlank(message = "*Name may not be blank")
    private String bookingName;
    @Column(name = "guestContact")
    @NotBlank(message = "*Please add a contact number.")
    private String bookingContact;

    @Column(name = "branchID")
    private Integer bookingBranch;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "*Select a date.")
    @Future(message = "*Please book atleast a day in advance.")
    private Date bookingDate;
    private String bookingTimeSlot;
    @Column(name = "guestCarMake")
    @NotBlank(message = "*Add Car Make.")
    private String bookingMake;
    @Column(name = "guestCarModel")
    @NotBlank(message = "*Add Car Model.")
    private String bookingModel;
    private String bookingPayment;
    private Integer serviceID;
    private String promoCode;
    private float bookingCost;
    private Integer staffID;

    public Integer getBookingID() {
        return bookingID;
    }

    public void setBookingID(Integer bookingID) {
        this.bookingID = bookingID;
    }

    public String getBookingName() {
        return bookingName;
    }

    public void setBookingName(String bookingName) {
        this.bookingName = bookingName;
    }

    public String getBookingContact() {
        return bookingContact;
    }

    public void setBookingContact(String bookingContact) {
        this.bookingContact = bookingContact;
    }

    public Integer getBookingBranch() {
        return bookingBranch;
    }

    public void setBookingBranch(Integer bookingBranch) {
        this.bookingBranch = bookingBranch;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getBookingTimeSlot() {
        return bookingTimeSlot;
    }

    public void setBookingTimeSlot(String bookingTimeSlot) {
        this.bookingTimeSlot = bookingTimeSlot;
    }

    public String getBookingMake() {
        return bookingMake;
    }

    public void setBookingMake(String bookingMake) {
        this.bookingMake = bookingMake;
    }

    public String getBookingModel() {
        return bookingModel;
    }

    public void setBookingModel(String bookingModel) {
        this.bookingModel = bookingModel;
    }

    public String getBookingPayment() {
        return bookingPayment;
    }

    public void setBookingPayment(String bookingPayment) {
        this.bookingPayment = bookingPayment;
    }

    public Integer getServiceID() {
        return serviceID;
    }

    public void setServiceID(Integer serviceID) {
        this.serviceID = serviceID;
    }

    public String getPromoCode() {
        return promoCode;
    }

    public void setPromoCode(String promoCode) {
        this.promoCode = promoCode;
    }

    public float getBookingCost() {
        return bookingCost;
    }

    public void setBookingCost(float bookingCost) {
        this.bookingCost = bookingCost;
    }

    public Integer getStaffID() {
        return staffID;
    }

    public void setStaffID(Integer staffID) {
        this.staffID = staffID;
    }

}
