package com.mhveterinary.veterinary.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String name;
    String breed;
    String type;
    String color;
    LocalDate birthday;
    String microchip_id;
}
