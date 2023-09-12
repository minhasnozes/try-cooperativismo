package com.example.demo.controller;

import com.example.demo.exceptions.AssociadoNotFoundException;
import com.example.demo.model.Associado;
import com.example.demo.repository.AssociadoRepository;
import com.example.demo.service.AssociadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/associados")

public class AssociadoController {

    @Autowired
    private AssociadoRepository associadoRepository;

    @Autowired
    private AssociadoService associadoService;
    @GetMapping
    public List<Associado> listAssociados() {
        return associadoRepository.findAll();
    }

    @PostMapping
    public Associado createAssociado(@RequestBody Associado associado) {
        return associadoRepository.save(associado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Associado> editAssociado(@PathVariable Integer id, @RequestBody Associado associado) {
        try {
            Associado newAssociado = associadoService.edit(id, associado);

            return ResponseEntity.ok(newAssociado);
        } catch (AssociadoNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
