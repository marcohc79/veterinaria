package com.veterinaryhc.veterinary.service;

import com.veterinaryhc.veterinary.entity.Owner;
import com.veterinaryhc.veterinary.repository.IOwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerService implements IOwnerService {
    @Autowired
    private IOwnerRepository ownerRepository;

    @Override
    public void create(Owner owner) {
        ownerRepository.save(owner);
    }

    @Override
    public void update(Owner owner) {
        ownerRepository.save(owner);
    }

    @Override
    public void delete(Owner owner) {
        ownerRepository.delete(owner);
    }

    @Override
    public List<Owner> findAll() {
        return ownerRepository.findAll();
    }

    @Override
    public Owner findById(Long id) {
        return ownerRepository.findById(id).orElse(null);
    }
}
