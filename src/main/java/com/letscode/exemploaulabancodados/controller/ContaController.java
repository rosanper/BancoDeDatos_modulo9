package com.letscode.exemploaulabancodados.controller;

import com.letscode.exemploaulabancodados.dto.ContaRequest;
import com.letscode.exemploaulabancodados.dto.ContaResponse;
import com.letscode.exemploaulabancodados.services.impl.ContaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contas")
public class ContaController {

    @Autowired
    private ContaServiceImpl contaService;

    @PostMapping("/create/{id}")
    private ContaResponse create(@PathVariable Integer id,@RequestBody ContaRequest contaRequest){
        return contaService.create(id,contaRequest);
    }
}
