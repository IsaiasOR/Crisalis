package com.Bootcamp.Crisalis.repository;

import com.Bootcamp.Crisalis.model.Client;
import com.Bootcamp.Crisalis.model.dto.ClientDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

    /*Client deleteByDni(Integer dni);*/

    Optional<Client> findByDni(Integer dni);

}
