package com.sql.carcaresystem.models;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Promo {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer promoID;
    private String promoName;
    private String promoCode;
    private LocalDateTime promoStart;
    private LocalDateTime promoEnd;
    private float promoModifier;
    private String promoDetails;

    public Integer getPromoID() {
        return promoID;
    }

    public void setPromoID(Integer promoID) {
        this.promoID = promoID;
    }

    public String getPromoName() {
        return promoName;
    }

    public void setPromoName(String promoName) {
        this.promoName = promoName;
    }

    public String getPromoCode() {
        return promoCode;
    }

    public void setPromoCode(String promoCode) {
        this.promoCode = promoCode;
    }

    public LocalDateTime getPromoStart() {
        return promoStart;
    }

    public LocalDateTime getPromoEnd() {
        return promoEnd;
    }

    public void setPromoStart(LocalDateTime promoStart) {
        this.promoStart = promoStart;
    }

    public void setPromoEnd(LocalDateTime promoEnd) {
        this.promoEnd = promoEnd;
    }

    public float getPromoModifier() {
        return promoModifier;
    }

    public void setPromoModifier(float promoModifer) {
        this.promoModifier = promoModifer;
    }

    public String getPromoDetails() {
        return promoDetails;
    }

    public void setPromoDetails(String promoDetails) {
        this.promoDetails = promoDetails;
    }

}
