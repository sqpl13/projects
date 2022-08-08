package com.sql.carcaresystem.services;

import java.util.Optional;

import com.sql.carcaresystem.models.Product;
import com.sql.carcaresystem.repositories.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product getProductByID(Integer productID) {
        Optional<Product> optional = productRepository.findById(productID);
        Product product = null;
        if (optional.isPresent()) {
            product= optional.get();
        } else {
            throw new RuntimeException("Product not found for id: " + productID);
        }
        return product;
    }
    
}
