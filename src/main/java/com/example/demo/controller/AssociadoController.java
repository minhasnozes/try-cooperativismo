package com.example.demo.controller;

import com.example.demo.model.Associado;
import com.example.demo.repository.AssociadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/associados")

public class AssociadoController {

    @Autowired
    private AssociadoRepository associadoRepository;
    @GetMapping
    public List<Associado> listAssociados() {
        return associadoRepository.findAll();
    }

    @PostMapping
    public Associado createAssociado(@RequestBody Associado associado) {
        return associadoRepository.save(associado);
    }
}
