package com.Bootcamp.Crisalis.repository;

import com.Bootcamp.Crisalis.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    Product deleteProductById(Integer id);
}
