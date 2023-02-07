package com.Bootcamp.Crisalis.repository;

import com.Bootcamp.Crisalis.model.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Integer> {
}
