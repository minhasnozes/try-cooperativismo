package com.example.demo.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class VotationId implements Serializable {

    private Long associate;

    private Long session;
}
