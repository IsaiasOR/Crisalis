package com.Bootcamp.Crisalis.repository;

import com.Bootcamp.Crisalis.model.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Integer> {

    @Query(value = "Select * FROM orders_details " +
            "WHERE orders_details.id_order_details " +
            "NOT IN (SELECT orders_order_details.order_details_id_order_details FROM orders_order_details)",
            nativeQuery = true)
    List<OrderDetails> orderDetailsNoOrder();

}
