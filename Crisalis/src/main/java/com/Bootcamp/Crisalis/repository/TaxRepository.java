package com.Bootcamp.Crisalis.repository;

import com.Bootcamp.Crisalis.model.Tax;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaxRepository extends JpaRepository<Tax, Integer> {


}
