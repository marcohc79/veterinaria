package com.mhveterinary.veterinary.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.mapping.Set;

import java.time.LocalDate;
import java.util.HashSet;

@Entity
@Data
@Table(name = "PETS")
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "breed", length = 50)
    private String breed;

    @Column(name = "type", nullable = false, length = 50)
    private String type;

    @Column(name = "colour", nullable = false, length = 50)
    private String colour;

    @Column(name = "sex", nullable = false)
    @Enumerated(EnumType.STRING)
    private Sex sex;

    @Column(name = "birth_date")
    private LocalDate birthday;

    @Column(name = "microchip_id", unique = true, length = 20 )
    private String microchip_id;

    @ManyToMany(mappedBy = "pets")
    private Set<Owner>  owners = new HashSet<>();

    public enum Sex{
        M,F
    }
}
