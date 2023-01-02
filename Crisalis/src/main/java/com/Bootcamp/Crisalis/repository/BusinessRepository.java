package com.Bootcamp.Crisalis.repository;

import com.Bootcamp.Crisalis.model.Business;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface BusinessRepository extends JpaRepository<Business, Integer> {

    Optional<Business> findByCuit(Integer cuit);

    Business deleteByCuit(Integer cuit);
}
