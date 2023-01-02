package com.Bootcamp.Crisalis.repository;

import com.Bootcamp.Crisalis.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmailAndPassword(String email,  String password);

    Optional<User> findByEmail(String email);

    Optional<User> findByDni(Integer dni);

    User delete(Optional<User> byEmailAndPassword);
}
