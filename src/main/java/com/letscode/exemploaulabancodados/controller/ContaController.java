package com.letscode.exemploaulabancodados.controller;

import com.letscode.exemploaulabancodados.dto.ContaRequest;
import com.letscode.exemploaulabancodados.dto.ContaResponse;
import com.letscode.exemploaulabancodados.services.impl.ContaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/contas")
public class ContaController {

    @Autowired
    private ContaServiceImpl contaService;

    @PostMapping("/create/{id}")
    private ContaResponse create(@PathVariable Integer id,@RequestBody ContaRequest contaRequest){
        return contaService.create(id,contaRequest);
    }

    @GetMapping
    private List<ContaResponse> getAll(){
        return contaService.getAll().stream().map(conta -> new ContaResponse(conta)).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    private ContaResponse findById(@PathVariable Integer id){
        return new ContaResponse(contaService.getById(id));
    }

    @PutMapping("/{id}")
    private ContaResponse update(@PathVariable Integer id, @RequestBody ContaRequest contaRequest){
        return new ContaResponse(contaService.update(contaRequest,id));
    }

    @DeleteMapping("/{id}")
    private void delete(@PathVariable Integer id){
        contaService.delete(id);
    }
}
