package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Sessao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Boolean votos;
    private Integer duracao;
    private LocalDateTime dataCriacao = LocalDateTime.now();;

    @ManyToOne
    private Assembleia assembleia;

    @ManyToOne
    private Associado associado;


}
