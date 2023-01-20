package com.Bootcamp.Crisalis.repository;

import com.Bootcamp.Crisalis.model.Service;
import com.Bootcamp.Crisalis.model.dto.ServiceDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional(readOnly = true)
public interface ServiceRepository extends JpaRepository<Service, Integer> {

    ServiceDTO deleteServiceById(Integer id);
}
