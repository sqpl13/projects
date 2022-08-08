package com.sql.carcaresystem.services;

import java.util.List;

import com.sql.carcaresystem.models.Order;
import com.sql.carcaresystem.repositories.OrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
	private OrderRepository orderRepository;

    @Override
    public List<Order> getAllOrders() {
        return (List<Order>) orderRepository.findAll();
    }

    @Override
    public void addOrder(Order order) {
        this.orderRepository.save(order); 
    }  
}