package com.veterinaryhc.veterinary.repository;

import com.veterinaryhc.veterinary.entity.Species;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ISpeciesRepository extends CrudRepository<Species, Long> {
    Optional<Species> findByName(String name);
}
