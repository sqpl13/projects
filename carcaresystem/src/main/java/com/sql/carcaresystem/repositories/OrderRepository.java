package com.sql.carcaresystem.repositories;

import com.sql.carcaresystem.models.Order;

import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Integer>{
    
}
