package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Sessao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Boolean votos;
    private int duracao = 1;


    @ManyToOne
    private Assembleia assembleia;

    @ManyToOne
    private Associado associado;


}
