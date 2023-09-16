package com.example.demo.controller;

import com.example.demo.model.Session;
import com.example.demo.model.Votation;
import com.example.demo.response.VotationResponse;
import com.example.demo.service.SessionService;
import com.example.demo.service.VotationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/votation")
public class VotationController {

    @Autowired
    private VotationService votationService;

    @Autowired
    private SessionService sessionService;

    @GetMapping
    public List<Votation> list() {
        return votationService.listAll();
    }

    @PostMapping
    public ResponseEntity<VotationResponse> save(@RequestBody Votation votation) {
        Long sessionId = votation.getSession().getId();
        Session session = sessionService.findById(sessionId);
        votation.setSession(session);

        System.out.println(votation.getSession() + " qwe " + votation.getSession().getOpen());

        if (session == null) {
            // Sessão não encontrada, você pode retornar um erro 404 Not Found se preferir
            VotationResponse response = new VotationResponse();
            response.setMessage("Sessão não encontrada");
            return ResponseEntity.notFound().build();
        }

        if (votationService.votationExpired(votation)) {
            VotationResponse response = new VotationResponse();
            response.setMessage("Votação encerrada");
            return ResponseEntity.badRequest().body(response);
        }

        if (votationService.hasVoted(votation)) {
            VotationResponse response = new VotationResponse();
            response.setMessage("Meliante já votou");
            return ResponseEntity.badRequest().body(response);
        }

        VotationResponse response = new VotationResponse();
        Votation savedVotation = votationService.save(votation);
        response.setVotation(savedVotation);
        return ResponseEntity.ok(response);
    }


}
