package com.example.demo.schedule;

import com.example.demo.service.SessaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SessaoScheduler {

    @Autowired
    private SessaoService sessaoService;

    @Scheduled(fixedDelay = 500) // Executa a cada 30 segundos (30.000 milissegundos)
    public void atualizarVotosSessoes() {
        // Aqui você pode implementar a lógica para buscar todas as sessões com duração expirada
        // e definir o voto como false
        sessaoService.atualizarVotosSessoesExpiradas();
    }
}
