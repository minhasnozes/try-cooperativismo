package com.example.demo.controller;

import com.example.demo.model.Assembleia;
import com.example.demo.repository.AssembleiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/assembleias")

public class AssembleiaController {

    @Autowired
    private AssembleiaRepository assembleiaRepository;

    @GetMapping
    public List<Assembleia> listAssembleias() {
        return assembleiaRepository.findAll();
    }

    @PostMapping
    public Assembleia createAssembleias(@RequestBody Assembleia assembleia) {
        return assembleiaRepository.save(assembleia);
    }
}
