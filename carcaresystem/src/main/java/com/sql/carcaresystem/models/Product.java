package com.sql.carcaresystem.models;

import java.util.Base64;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer productID;
    private String productName;
    private float productPrice;
    private String productDetails;
    @Lob
    private byte[] productImage;

    public Integer getProductID() {
        return productID;
    }

    public void setProductID(Integer productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(float productPrice) {
        this.productPrice = productPrice;
    }


    public String getProductDetails() {
        return productDetails;
    }

    public void setProductDetails(String productDetails) {
        this.productDetails = productDetails;
    }

    public String getProductImage() {
        return Base64.getMimeEncoder().encodeToString(productImage);
    }

    public void setProductImage(byte[] productImage) {
        this.productImage = productImage;
    }

}

