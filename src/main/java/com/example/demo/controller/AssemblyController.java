package com.example.demo.controller;

import com.example.demo.exceptions.AssemblyNotFoundException;
import com.example.demo.model.Assembly;
import com.example.demo.repository.AssemblyRepository;
import com.example.demo.service.AssemblyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/assembly")
public class AssemblyController {

    @Autowired
    private AssemblyRepository assemblyRepository;

    @Autowired
    private AssemblyService assemblyService;

    @GetMapping
    public List<Assembly> listAssembleias() {
        return assemblyRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity <Assembly> findById (@PathVariable Long id) {
        Assembly assembly = assemblyService.findById(id);

        if (assembly != null) {
            return ResponseEntity.ok(assembly);
        } else {
            throw new AssemblyNotFoundException("The Assembly ID" + "has not found");
        }
    }

    @PostMapping
    public Assembly createAssembleias(@RequestBody Assembly assembly) {
        return assemblyRepository.save(assembly);
    }

    @PutMapping("/{id}")
    public ResponseEntity <Assembly> updateAssembly(@PathVariable Long id, @RequestBody Assembly assembleia) {
        try {
            Assembly novaAssembly = assemblyService.edit(id, assembleia);

            return ResponseEntity.ok(assembleia);
        } catch (AssemblyNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
