package com.Bootcamp.Crisalis.repository;

import com.Bootcamp.Crisalis.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface ClientRepository extends JpaRepository<Client, Integer> {

    Client deleteByDni(Integer dni);

    Optional<Client> findByDni(Integer dni);
}
