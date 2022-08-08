package com.sql.carcaresystem.services;

import java.util.List;

import com.sql.carcaresystem.models.Order;

public interface OrderService {
    List<Order> getAllOrders();
	void addOrder(Order order);
}
