package com.example.demo.response;

import com.example.demo.model.Votation;
import lombok.Data;

@Data
public class VotationResponse {
    private Votation votation;
    private String message;
}
