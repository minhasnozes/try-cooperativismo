package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // True ou False = True: can be voted, session open.
    // False: cant receive vote, session closed
    private Boolean open = Boolean.TRUE;

    private Integer duration = 1;

    private LocalDateTime dateCreated = LocalDateTime.now();

    @ManyToOne
    private Assembly assembly;

}
