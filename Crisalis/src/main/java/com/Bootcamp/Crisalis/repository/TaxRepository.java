package com.Bootcamp.Crisalis.repository;

import com.Bootcamp.Crisalis.model.Tax;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface TaxRepository extends JpaRepository<Tax, Integer> {

    Optional<Tax> findByName(String name);

    Tax deleteByName(String name);
}
