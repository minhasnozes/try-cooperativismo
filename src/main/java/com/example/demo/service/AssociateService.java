package com.example.demo.service;

import com.example.demo.exceptions.AssociateNotFoundException;
import com.example.demo.model.Associate;
import com.example.demo.repository.AssociateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssociateService {

    @Autowired
    private AssociateRepository associateRepository;

    public Associate findById(Long id) {
        return associateRepository.findById(id).orElse(null);
    }

    public Associate save(Associate associate) {
        return associateRepository.save(associate);
    }

    public void delete(Long id) {
        associateRepository.deleteById(id);
    }

    public Associate edit(Long id, Associate associate) {
        Associate associateExists = this.findById(id);

        if (associateExists != null) {
            associateExists.setCpf(associate.getCpf());
            associateExists.setName(associate.getName());

            return this.save(associateExists);
        } else {
            throw new AssociateNotFoundException("Associate with " + id + " has not found.");
        }
    }
}
