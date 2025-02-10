package com.veterinaryhc.veterinary.service;

import com.veterinaryhc.veterinary.entity.Pet;

import java.util.List;

public interface IPetService {
    void create(Pet pet);
    void update(Pet pet);
    void delete(Pet pet);
    List<Pet> findAll();
    Pet findById(Long id);
}