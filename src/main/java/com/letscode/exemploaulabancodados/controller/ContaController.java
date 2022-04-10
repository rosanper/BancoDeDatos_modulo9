package com.letscode.exemploaulabancodados.controller;

import com.letscode.exemploaulabancodados.dto.ContaRequest;
import com.letscode.exemploaulabancodados.dto.ContaResponse;
import com.letscode.exemploaulabancodados.models.Conta;
import com.letscode.exemploaulabancodados.models.TipoConta;
import com.letscode.exemploaulabancodados.projection.ContaView;
import com.letscode.exemploaulabancodados.services.impl.ContaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/contas")
public class ContaController {

    @Autowired
    private ContaServiceImpl contaService;

    @PostMapping("/create/{id}")
    private ContaResponse create(@PathVariable Integer id,@RequestBody @Valid ContaRequest contaRequest){
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
    private ContaResponse update(@PathVariable Integer id, @RequestBody @Valid ContaRequest contaRequest){
        return new ContaResponse(contaService.update(contaRequest,id));
    }

    @DeleteMapping("/{id}")
    private void delete(@PathVariable Integer id){
        contaService.delete(id);
    }

    @GetMapping("/Query")
    private List<Conta> getByTipoContaENomeUsuario(@RequestParam String nome,
                                                   @RequestParam TipoConta tipoConta){
        return contaService.getByQuery(tipoConta, nome);

    }

    @GetMapping("/GreaterThan")
    private Page<Conta> getContaSaldoGreaterThan(@RequestParam BigDecimal valor,
                                                 @RequestParam(required = false, defaultValue = "0") int page,
                                                 @RequestParam(required = false, defaultValue = "5") int size){
        return contaService.getContasSaldoGreaterThan(valor,page,size);
    }

    @GetMapping("/View")
    private List<ContaView> getByTipoConta(@RequestParam TipoConta tipoConta){
        return contaService.getByTipoConta(tipoConta);
    }
}
