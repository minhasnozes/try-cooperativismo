package com.example.demo.controller;

import com.example.demo.model.Session;
import com.example.demo.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/session")
public class SessionController {

    @Autowired
    private SessionService sessionService;

    @GetMapping
    public List<Session> listAll() {
        return sessionService.findAll();
    }

    @GetMapping("/{id}")
    public Session findById(@PathVariable Long id) {
        return sessionService.findById(id);
    }

    @PostMapping
    public Session save(@RequestBody Session session) {
        return sessionService.save(session);
    }
}
