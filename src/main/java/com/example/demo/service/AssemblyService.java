package com.example.demo.service;

import com.example.demo.exceptions.AssembleiaNotFoundException;
import com.example.demo.model.Assembleia;
import com.example.demo.repository.AssembleiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;


@Service
public class AssemblyService {

    @Autowired
    private AssembleiaRepository assemblyRepository;

    public Assembleia findById(Integer id) {
        Optional<Assembleia> optionalAssembly = assemblyRepository.findById(id);

        if (optionalAssembly.isPresent()) {
            return optionalAssembly.get();
        } else {
            throw new AssembleiaNotFoundException("The Assembly with " + id + " has not found");
        }
    }

    public Assembleia save (Assembleia assembly) {
        return assemblyRepository.save(assembly);
    }

    public void delete(Integer id) {
        assemblyRepository.deleteById(id);}
    }

