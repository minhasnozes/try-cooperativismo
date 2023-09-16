package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@IdClass(VotationId.class)
@Data
public class Votation {

    @Id
    @ManyToOne
    private Associate associate;

    @Id
    @ManyToOne
    private Session session;

    // YES OR NO.
    private String vote;
}
