package com.veterinaryhc.veterinary.service;

import com.veterinaryhc.veterinary.entity.Owner;

import java.util.List;

public interface IOwnerService {
    void create(Owner owner);
    void update(Owner owner);
    void delete(Owner owner);
    List<Owner> findAll();
    Owner findById(Long id);
}
