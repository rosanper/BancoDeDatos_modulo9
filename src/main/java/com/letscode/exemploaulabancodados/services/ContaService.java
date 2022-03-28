package com.letscode.exemploaulabancodados.services;

import com.letscode.exemploaulabancodados.dto.ContaRequest;
import com.letscode.exemploaulabancodados.dto.ContaResponse;

public interface ContaService {
    ContaResponse create(Integer id, ContaRequest contaRequest);
}
