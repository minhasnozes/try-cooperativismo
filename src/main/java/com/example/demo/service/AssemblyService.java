package com.example.demo.service;

import com.example.demo.exceptions.AssemblyNotFoundException;
import com.example.demo.model.Assembly;
import com.example.demo.repository.AssemblyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class AssemblyService {

    @Autowired
    private AssemblyRepository assemblyRepository;

    public Assembly findById(Long id) {
        Optional<Assembly> optionalAssembly = assemblyRepository.findById(id);

        if (optionalAssembly.isPresent()) {
            return optionalAssembly.get();
        } else {
            throw new AssemblyNotFoundException("The Assembly with " + id + " has not found");
        }
    }

    public Assembly save(Assembly assembly) {
        return assemblyRepository.save(assembly);
    }
    public Assembly edit(Long id, Assembly assembly) {
        Assembly assemblyExists = this.findById(id);

        if (assemblyExists != null) {
            assemblyExists.setAgenda(assembly.getAgenda());
            return this.assemblyRepository.save(assemblyExists);
        } else {
            throw new AssemblyNotFoundException("The assembly" + id + "has not found.");
        }

    }

    public void delete(Long id) {
        assemblyRepository.deleteById(id);
    }
}

