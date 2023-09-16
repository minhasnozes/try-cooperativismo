package com.example.demo.service;

import com.example.demo.model.Votation;
import com.example.demo.repository.VotationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VotationService {

    @Autowired
    private VotationRepository votationRepository;

    public Votation save(Votation votation) {
        return votationRepository.save(votation);

    }

    public boolean hasVoted(Votation votation) {
        return votationRepository.findByAssociateIdAndSessionId(votation.getAssociate().getId(), votation.getSession().getId()) != null;

    }

    public List<Votation> listAll() {
        return votationRepository.findAll();
    }

    public boolean votationExpired(Votation votation) {
        return !votation.getSession().getOpen();
    }
}
