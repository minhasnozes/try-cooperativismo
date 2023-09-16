package com.example.demo.service;

import com.example.demo.model.Session;
import com.example.demo.repository.SessionRepository;
import com.example.demo.util.VotingSessionTimer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class SessionService {

    @Autowired
    private SessionRepository sessionRepository;

    @Autowired
    private VotingSessionTimer votingSessionTimer;


    @GetMapping
    public List<Session> findAll() {
        return sessionRepository.findAll();
    }

    public Session findById(Long id) {
        return sessionRepository.findById(id).orElse(null);
    }

    public Session save(Session session) {
        if (session.getDuration() == null) {
            session.setDuration(1);
        }
        votingSessionTimer.startVotingSession(session, session.getDuration() * 60000);
        return sessionRepository.save(session);
    }

}
