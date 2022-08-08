package com.sql.carcaresystem.repositories;

import java.util.List;

import com.sql.carcaresystem.models.Product;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {
    
    @Query("SELECT p FROM  Product p WHERE p.productID != ?1 ORDER BY RAND ()")
    List<Product> findAllExceptId(Integer id);

    @Query (value = "SELECT * FROM product ORDER BY RAND () LIMIT 4", nativeQuery = true)
    List<Product> getFourRandomProducts();

    @Query (value = "SELECT * FROM product ORDER BY productName", nativeQuery = true)
    List<Product> getAllProductsOrderByName();

}
