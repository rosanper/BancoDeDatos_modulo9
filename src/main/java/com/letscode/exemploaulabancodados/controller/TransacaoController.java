package com.letscode.exemploaulabancodados.controller;

import com.letscode.exemploaulabancodados.dto.TransacaoRequest;
import com.letscode.exemploaulabancodados.dto.TransacaoResponse;
import com.letscode.exemploaulabancodados.models.Transacao;
import com.letscode.exemploaulabancodados.services.impl.TransacaoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/create")
    public TransacaoResponse create(@RequestParam Integer id, @RequestBody TransacaoRequest transacaoRequest){
        return new TransacaoResponse(transacaoService.create(id,transacaoRequest));
    }

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable Integer id){
        transacaoService.delete(id);
    }
}
