package com.example.demo.service;

import com.example.demo.model.Assembleia;
import com.example.demo.repository.AssembleiaRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class AssemblyService {

    @Autowired
    public AssembleiaRepository assemblyRepository;

    public Assembleia findById(Integer id) {
        return assemblyRepository.findById(id).orElse(findById(id));
    }

    public Assembleia save(Assembleia assembly) {
        return assemblyRepository.save(assembly);
    }

    public void delete(Integer id) {
        assemblyRepository.deleteById(id);}
    }
}
