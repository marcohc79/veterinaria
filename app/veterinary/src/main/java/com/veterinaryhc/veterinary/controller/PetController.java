package com.veterinaryhc.veterinary.controller;

import com.veterinaryhc.veterinary.entity.Pet;
import com.veterinaryhc.veterinary.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PetController {
    @Autowired
    private PetService petService;

    @PostMapping("/pet")
    public String createPet(@RequestBody Pet pet) {
        petService.create(pet);
        return "Pet created";
    }
}
