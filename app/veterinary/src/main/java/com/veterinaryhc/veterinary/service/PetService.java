package com.veterinaryhc.veterinary.service;

import com.veterinaryhc.veterinary.entity.Breed;
import com.veterinaryhc.veterinary.entity.Owner;
import com.veterinaryhc.veterinary.entity.Pet;
import com.veterinaryhc.veterinary.entity.Species;
import com.veterinaryhc.veterinary.repository.IBreedRepository;
import com.veterinaryhc.veterinary.repository.IOwnerRepository;
import com.veterinaryhc.veterinary.repository.IPetRepository;
import com.veterinaryhc.veterinary.repository.ISpeciesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService implements IPetService {

    @Autowired
    private IBreedRepository breedRepository;

    @Autowired
    private ISpeciesRepository speciesRepository;

    @Autowired
    private IPetRepository petRepository;

    @Autowired
    private IOwnerRepository ownerRepository;

    @Override
    public void create(Pet pet) {
        Species species = speciesRepository.findByName(pet.getBreed().getSpecies().getName())
                .orElseGet(() -> {
                    Species newSpecies = new Species();
                    newSpecies.setName(pet.getBreed().getSpecies().getName());
                    return speciesRepository.save(newSpecies);
                });

        Breed breed = breedRepository.findByNameAndSpecies(pet.getBreed().getName(), species)
                .orElseGet(() -> {
                    Breed newBreed = new Breed();
                    newBreed.setName(pet.getBreed().getName());
                    newBreed.setSpecies(species);
                    return breedRepository.save(newBreed);
                });

        Owner owner = ownerRepository.findByEmail(pet.getOwner().getEmail())
                .orElseGet(()->{
                    Owner newOwner = new Owner();
                    newOwner.setName(pet.getOwner().getName());
                    newOwner.setSurname(pet.getOwner().getSurname());
                    newOwner.setEmail(pet.getOwner().getEmail());
                    newOwner.setPhone(pet.getOwner().getPhone());
                    newOwner.setAddress(pet.getOwner().getAddress());
                    return ownerRepository.save(newOwner);
                });

        pet.setSpecies(species);
        pet.setBreed(breed);
        pet.setOwner(owner);

        petRepository.save(pet);
    }

    @Override
    public void update(Pet pet) {
        petRepository.save(pet);
    }

    @Override
    public void delete(Pet pet) {
        petRepository.delete(pet);
    }

    @Override
    public List<Pet> findAll() {
        return (List<Pet>) petRepository.findAll();
    }

    @Override
    public Pet findById(Long id) {
        return petRepository.findById(id).orElse(null);
    }
}
