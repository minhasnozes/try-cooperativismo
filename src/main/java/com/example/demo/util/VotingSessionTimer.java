package com.example.demo.util;

import com.example.demo.model.Sessao;
import com.example.demo.repository.SessaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Component
public class VotingSessionTimer {

    private ScheduledExecutorService executor;

    @Autowired
    private SessaoRepository sessaoRepository;

    public void startVotingSession(Sessao sessao, long durationInMilliseconds) {
        executor = Executors.newSingleThreadScheduledExecutor();
        executor.schedule(() -> {
            endVotingSession(sessao);

            executor.shutdown();
        }, durationInMilliseconds, TimeUnit.MILLISECONDS);
    }

    private void endVotingSession(Sessao sessao) {
        sessao.setVotos(false);
        sessaoRepository.save(sessao);
    }
}
