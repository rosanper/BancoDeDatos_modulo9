package com.letscode.exemploaulabancodados.services.impl;

import com.letscode.exemploaulabancodados.dto.TransacaoRequest;
import com.letscode.exemploaulabancodados.models.Conta;
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

    @Autowired
    private ContaServiceImpl contaService;

    @Override
    public List<Transacao> getAll() {
        return transacaoRepository.findAll();
    }

    @Override
    public Transacao getById(Integer id){
        return transacaoRepository.findById(id).orElseThrow();
    }

    @Override
    public Transacao create(Integer id, TransacaoRequest transacaoRequest) {
        Conta conta = contaService.getById(id);
        Transacao transacao = new Transacao(transacaoRequest,conta);
        transacaoRepository.save(transacao);
        return transacao;
    }

    @Override
    public void delete(Integer id){
        Transacao transacao = getById(id);
        transacaoRepository.delete(transacao);
    }
}
