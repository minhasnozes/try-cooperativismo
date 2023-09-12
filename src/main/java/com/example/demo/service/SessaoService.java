package com.example.demo.service;

import com.example.demo.model.Associado;
import com.example.demo.model.Sessao;
import com.example.demo.repository.SessaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SessaoService {

    @Autowired
    private SessaoRepository sessaoRepository;


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

        return sessaoRepository.save(sessao);
    }

    public void atualizarVotosSessoesExpiradas() {
        List<Sessao> sessoes = this.findAll();
        sessoes.forEach(this::aplicarLogicaSessao);
    }

    private void aplicarLogicaSessao(Sessao sessao) {
        if (sessao.getDataCriacao() == null) {
            sessao.setVotos(false);
            this.save(sessao);
        } else {
            LocalDateTime dataCriacaoMaisDuracao = sessao.getDataCriacao().plusMinutes(sessao.getDuracao());
            if (LocalDateTime.now().isAfter(dataCriacaoMaisDuracao)) {
                sessao.setVotos(false);
                this.save(sessao);
            }
        }

    }
}
