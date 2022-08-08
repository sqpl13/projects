package com.sql.carcaresystem.repositories;

import java.util.List;

import com.sql.carcaresystem.models.Promo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PromoRepository extends CrudRepository<Promo, Integer> {

    @Query (value = "SELECT * FROM promo WHERE promoStart  BETWEEN NOW()  AND DATE_ADD(NOW(), INTERVAL 6 MONTH)", nativeQuery = true)
    List<Promo> findNearPromos();

    @Query (value = "SELECT * FROM promo WHERE NOW() BETWEEN promoStart  AND promoEnd", nativeQuery = true)
    List<Promo> findCurrentPromos();

    
}
