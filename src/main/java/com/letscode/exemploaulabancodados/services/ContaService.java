package com.letscode.exemploaulabancodados.services;

import com.letscode.exemploaulabancodados.dto.ContaRequest;
import com.letscode.exemploaulabancodados.dto.ContaResponse;
import com.letscode.exemploaulabancodados.models.Conta;

import java.util.List;

public interface ContaService {
    ContaResponse create(Integer id, ContaRequest contaRequest);
    List<Conta> getAll();
    Conta getById(Integer id);
    Conta update(ContaRequest contaRequest, Integer id);
    void delete(Integer id);
}
