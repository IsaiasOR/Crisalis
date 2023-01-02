package com.Bootcamp.Crisalis.repository;

import com.Bootcamp.Crisalis.model.Need;
import com.Bootcamp.Crisalis.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface ProductRepository extends JpaRepository<Product, Integer> {

    Optional<Product> findByNeed(Need need);

    Product deleteByNeed(Need need);
}
