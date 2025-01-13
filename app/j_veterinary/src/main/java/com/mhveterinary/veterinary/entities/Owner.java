package com.mhveterinary.veterinary.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.EqualsAndHashCode;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString(exclude = "pets")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "OWNERS")
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Size (max = 50)
    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @NotBlank
    @Size (max = 50)
    @Column(name = "surname", nullable = false, length = 50)
    private String surname;

    @Email
    @Size(max = 50)
    @Column(name = "email", unique = true, length = 50)
    private String email;

    @NotBlank
    @Size (max = 9)
    @Pattern(regexp = "\\d+")
    @Column(name = "dni", unique = true, nullable = false, length = 9)
    private String dni;

    @NotBlank
    @Size (max = 15)
    @Column(name = "phone", length = 15)
    private String phone;

    @Size(max = 255)
    @NotBlank
    @Column(name = "address", length = 255)
    private String address;

    @ManyToMany
    @JoinTable(
            name = "OWNER_PET",
            joinColumns = @JoinColumn(name = "owner_id"),
            inverseJoinColumns = @JoinColumn(name = "pet_id")
    )
    private Set<Pet> pets = new HashSet<>();
}
