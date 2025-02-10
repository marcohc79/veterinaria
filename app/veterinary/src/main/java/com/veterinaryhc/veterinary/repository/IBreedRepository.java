package com.veterinaryhc.veterinary.repository;

import com.veterinaryhc.veterinary.entity.Breed;
import com.veterinaryhc.veterinary.entity.Species;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IBreedRepository extends CrudRepository<Breed, Long> {
    Optional<Breed> findByNameAndSpecies(String name, Species species);
}
