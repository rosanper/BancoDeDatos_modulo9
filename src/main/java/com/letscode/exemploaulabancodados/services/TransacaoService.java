package com.letscode.exemploaulabancodados.services;

import com.letscode.exemploaulabancodados.dto.TransacaoRequest;
import com.letscode.exemploaulabancodados.models.Transacao;

import java.util.List;

public interface TransacaoService {

    List<Transacao> getAll();

    Transacao getById(Integer id);

    Transacao create(Integer id, TransacaoRequest transacaoRequest);

    void delete(Integer id);
}
