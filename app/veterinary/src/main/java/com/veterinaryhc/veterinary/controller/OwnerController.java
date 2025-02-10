package com.veterinaryhc.veterinary.controller;

import com.veterinaryhc.veterinary.entity.Owner;
import com.veterinaryhc.veterinary.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class OwnerController {
    @Autowired
    private OwnerService ownerService;

    @PostMapping("/owner")
    public String save(@RequestBody Owner owner) {
        ownerService.create(owner);
        return "Owner created";
    }

    @GetMapping("/owners")
    public List<Owner> getAll() {
        return ownerService.findAll();
    }

    @GetMapping("/owner/{id}")
    public ResponseEntity<Owner> getById(@PathVariable Long id) {
        Owner owner = ownerService.findById(id);
        if (owner == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(owner, HttpStatus.OK);
    }

    @DeleteMapping("/owner/{id}")
    public ResponseEntity<Owner> delete(@PathVariable Long id) {
        Owner owner = ownerService.findById(id);
        if (owner == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        ownerService.delete(owner);
        return new ResponseEntity<>(owner, HttpStatus.OK);
    }

    @PatchMapping("/owner/{id}")
    public ResponseEntity<Owner> partialUpdate(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
        Owner ownerOld  = ownerService.findById(id);
        if (ownerOld == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        updates.forEach((key, value) -> {
            Field field = ReflectionUtils.findField(Owner.class, key);
            if (field != null) {
                field.setAccessible(true);
                ReflectionUtils.setField(field, ownerOld, value);
            }
        });

        ownerService.update(ownerOld);
        return new ResponseEntity<>(ownerOld, HttpStatus.OK);
    }
}
