package com.example.demo.repository;

import com.example.demo.model.Session;
import com.example.demo.model.Votation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VotationRepository extends JpaRepository<Votation, Long> {
    Votation findByAssociateId(Long associateId);

    Votation findBySessionId(Long sessionId);

    Votation findByAssociateIdAndSessionId(Long associate, Long session);
}
