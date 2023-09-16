package com.example.demo.util;

import com.example.demo.model.Session;
import com.example.demo.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Component
public class VotingSessionTimer {

    private ScheduledExecutorService executor;

    @Autowired
    private SessionRepository sessionRepository;

    public void startVotingSession(Session session, long durationInMilliseconds) {
        executor = Executors.newSingleThreadScheduledExecutor();
        executor.schedule(() -> {
            endVotingSession(session);

            executor.shutdown();
        }, durationInMilliseconds, TimeUnit.MILLISECONDS);
    }

    private void endVotingSession(Session session) {
        session.setOpen(false);
        sessionRepository.save(session);
    }
}
