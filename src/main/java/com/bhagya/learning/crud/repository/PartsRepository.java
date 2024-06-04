package com.bhagya.learning.crud.repository;

import com.bhagya.learning.crud.entity.Parts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PartsRepository extends JpaRepository<Parts, Integer> {

    Optional<Parts> findByPartNumber(final String partNumber);


}
