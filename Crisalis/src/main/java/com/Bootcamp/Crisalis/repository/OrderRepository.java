package com.Bootcamp.Crisalis.repository;

import com.Bootcamp.Crisalis.model.Order;
import com.Bootcamp.Crisalis.model.dto.OrderDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

}
