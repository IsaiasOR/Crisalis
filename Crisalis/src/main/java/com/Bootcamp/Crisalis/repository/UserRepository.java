package com.Bootcamp.Crisalis.repository;

import com.Bootcamp.Crisalis.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmailAndPass(String email, String pass);

    Optional<User> findByEmail(String email);

    Optional<User> findByDni(Integer dni);

/*    User deleteByDni(Integer dni);

    User deleteUserById(Integer id);*/

    User findUserById(Integer id);
}
