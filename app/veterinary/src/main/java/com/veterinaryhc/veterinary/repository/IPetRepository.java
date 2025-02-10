package com.veterinaryhc.veterinary.repository;

import com.veterinaryhc.veterinary.entity.Pet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IPetRepository extends CrudRepository<Pet, Long> {
}
