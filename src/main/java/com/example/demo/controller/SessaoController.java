package com.example.demo.controller;

import com.example.demo.model.Assembleia;
import com.example.demo.model.Sessao;
import com.example.demo.service.SessaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sessoes")
public class SessaoController {

    @Autowired
    private SessaoService sessaoService;

    @GetMapping
    public List<Sessao> listAll() {
        return sessaoService.findAll();
    }

    @GetMapping("/{id}")
    public Sessao findById(@PathVariable Integer id) {
        return sessaoService.findById(id);
    }

    @PostMapping
    public Sessao save(@RequestBody Sessao sessao) {
        return sessaoService.save(sessao);
    }
}
