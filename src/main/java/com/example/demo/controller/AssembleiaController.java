package com.example.demo.controller;

import com.example.demo.exceptions.AssembleiaNotFoundException;
import com.example.demo.model.Assembleia;
import com.example.demo.repository.AssembleiaRepository;
import com.example.demo.service.AssemblyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/assembleias")
public class AssembleiaController {

    @Autowired
    private AssembleiaRepository assembleiaRepository;

    @Autowired
    private AssemblyService assemblyService;

    @GetMapping
    public List<Assembleia> listAssembleias() {
        return assembleiaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity <Assembleia> findById (@PathVariable Integer id) {
        Assembleia assembly = assemblyService.findById(id);

        if (assembly != null) {
            return ResponseEntity.ok(assembly);
        } else {
            throw new AssembleiaNotFoundException("The Assembly ID" + "has not found");
        }
    }

    @PostMapping
    public Assembleia createAssembleias(@RequestBody Assembleia assembleia) {
        return assembleiaRepository.save(assembleia);
    }

    @PutMapping("/{id}")
    public ResponseEntity <Assembleia> updateAssembly(@PathVariable Integer id, @RequestBody Assembleia assembleia) {
        try {
            Assembleia novaAssembleia = assemblyService.edit(id, assembleia);

            return ResponseEntity.ok(assembleia);
        } catch (AssembleiaNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
