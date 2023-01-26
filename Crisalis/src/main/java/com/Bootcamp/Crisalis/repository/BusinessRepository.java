package com.Bootcamp.Crisalis.repository;

import com.Bootcamp.Crisalis.model.Business;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BusinessRepository extends JpaRepository<Business, Integer> {

    Optional<Business> findByCuit(Integer cuit);

    Business findBusinessById(Integer id);

}
