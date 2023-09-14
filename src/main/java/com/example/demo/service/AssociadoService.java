package com.example.demo.service;

import com.example.demo.exceptions.AssociadoNotFoundException;
import com.example.demo.model.Associado;
import com.example.demo.repository.AssociadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssociadoService {

    @Autowired
    private AssociadoRepository associadoRepository;

    public Associado findById(Integer id) {
        return associadoRepository.findById(id).orElse(null);
    }

    public Associado save(Associado associado) {
        return associadoRepository.save(associado);
    }

    public void delete(Integer id) {
        associadoRepository.deleteById(id);
    }

    public Associado edit(Integer id, Associado associado) {
        Associado associadoExists = this.findById(id);

        if (associadoExists != null) {
            associadoExists.setCpf(associado.getCpf());
            associadoExists.setNome(associado.getNome());

            return this.save(associadoExists);
        } else {
            throw new AssociadoNotFoundException("Associate with " + id + " has not found.");
        }
    }
}
