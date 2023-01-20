package com.Bootcamp.Crisalis.repository;

import com.Bootcamp.Crisalis.model.Business;
import com.Bootcamp.Crisalis.model.dto.BusinessDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface BusinessRepository extends JpaRepository<Business, Integer> {

    Optional<BusinessDTO> findByCuit(Integer cuit);

    BusinessDTO findBusinessById(Integer id);

    Business deleteByCuit(Integer cuit);

    Business deleteBusinessById(Integer id);
}
