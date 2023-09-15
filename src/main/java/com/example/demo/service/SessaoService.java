package com.example.demo.service;

import com.example.demo.model.Associado;
import com.example.demo.model.Sessao;
import com.example.demo.repository.SessaoRepository;
import com.example.demo.util.VotingSessionTimer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SessaoService {

    @Autowired
    private SessaoRepository sessaoRepository;

    @Autowired
    private VotingSessionTimer votingSessionTimer;


    @GetMapping
    public List<Sessao> findAll() {
        return sessaoRepository.findAll();
    }

    public Sessao findById(Integer id) {
        return sessaoRepository.findById(id).orElse(null);
    }

    public Sessao save(Sessao sessao) {
        if (sessao.getDuracao() == null) {
            sessao.setDuracao(1);
        }
        votingSessionTimer.startVotingSession(sessao, sessao.getDuracao() * 60000);
        return sessaoRepository.save(sessao);
    }
}
