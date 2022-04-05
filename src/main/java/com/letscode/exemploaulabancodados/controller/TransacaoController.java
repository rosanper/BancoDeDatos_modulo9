package com.letscode.exemploaulabancodados.controller;

import com.letscode.exemploaulabancodados.models.Transacao;
import com.letscode.exemploaulabancodados.services.impl.TransacaoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {

    @Autowired
    private TransacaoServiceImpl transacaoService;

    @GetMapping
    public List<Transacao> getAll(){
        return transacaoService.getAll();
    }
}
