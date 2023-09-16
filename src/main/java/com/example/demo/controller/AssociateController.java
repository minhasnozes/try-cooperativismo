package com.example.demo.controller;

import com.example.demo.exceptions.AssociateNotFoundException;
import com.example.demo.model.Associate;
import com.example.demo.repository.AssociateRepository;
import com.example.demo.service.AssociateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/associate")

public class AssociateController {

    @Autowired
    private AssociateRepository associateRepository;

    @Autowired
    private AssociateService associateService;
    @GetMapping
    public List<Associate> listAssociados() {
        return associateRepository.findAll();
    }

    @PostMapping
    public Associate createAssociado(@RequestBody Associate associate) {
        return associateRepository.save(associate);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Associate> editAssociado(@PathVariable Long id, @RequestBody Associate associate) {
        try {
            Associate newAssociate = associateService.edit(id, associate);

            return ResponseEntity.ok(newAssociate);
        } catch (AssociateNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
