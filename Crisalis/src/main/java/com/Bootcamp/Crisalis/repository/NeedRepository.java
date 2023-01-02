package com.Bootcamp.Crisalis.repository;

import com.Bootcamp.Crisalis.model.Need;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface NeedRepository extends JpaRepository<Need, Integer> {

    Optional<Need> findByName(String name);

    Need deleteByName(String name);
}
