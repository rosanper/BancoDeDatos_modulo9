package com.letscode.exemploaulabancodados.services;

import com.letscode.exemploaulabancodados.dto.ContaRequest;
import com.letscode.exemploaulabancodados.dto.ContaResponse;
import com.letscode.exemploaulabancodados.models.Conta;
import com.letscode.exemploaulabancodados.models.TipoConta;
import com.letscode.exemploaulabancodados.projection.ContaView;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;
import java.util.List;

public interface ContaService {
    ContaResponse create(Integer id, ContaRequest contaRequest);
    List<Conta> getAll();
    Conta getById(Integer id);
    Conta update(ContaRequest contaRequest, Integer id);
    void delete(Integer id);
    List<Conta> getByUsuario(String cpf, String nome, Integer agencia);
    Page<Conta> getContasSaldoGreaterThan(BigDecimal bigDecimal, int page, int size);

    List<ContaView> getByTipoConta(TipoConta tipoConta);
}
