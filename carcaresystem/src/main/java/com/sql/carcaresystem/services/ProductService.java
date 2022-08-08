package com.sql.carcaresystem.services;

import com.sql.carcaresystem.models.Product;

public interface ProductService {
    Product getProductByID(Integer productID);
}

