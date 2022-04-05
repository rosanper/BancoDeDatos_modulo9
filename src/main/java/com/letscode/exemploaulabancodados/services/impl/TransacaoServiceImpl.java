package com.letscode.exemploaulabancodados.services.impl;

import com.letscode.exemploaulabancodados.models.Transacao;
import com.letscode.exemploaulabancodados.repositories.TransacaoRepository;
import com.letscode.exemploaulabancodados.services.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransacaoServiceImpl implements TransacaoService {

    @Autowired
    private TransacaoRepository transacaoRepository;

    @Override
    public List<Transacao> getAll() {
        return transacaoRepository.findAll();
    }
}
