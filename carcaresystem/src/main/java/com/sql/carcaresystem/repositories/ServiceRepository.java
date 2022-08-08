package com.sql.carcaresystem.repositories;

import java.util.List;

import com.sql.carcaresystem.models.Service;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ServiceRepository extends CrudRepository<Service, Integer> {
    
    @Query (value = "SELECT s FROM Service s ORDER by s.servicePrice")
    List<Service> sortServiceByPrice();

    @Query (value = "SELECT s FROM Service s ORDER by s.serviceName")
    List<Service> sortServiceByName();
}