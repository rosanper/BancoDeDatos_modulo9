package com.letscode.exemploaulabancodados.services.impl;

import com.letscode.exemploaulabancodados.dto.ContaRequest;
import com.letscode.exemploaulabancodados.dto.ContaResponse;
import com.letscode.exemploaulabancodados.models.Conta;
import com.letscode.exemploaulabancodados.models.Usuario;
import com.letscode.exemploaulabancodados.repositories.ContaRepository;
import com.letscode.exemploaulabancodados.repositories.UsuarioRepository;
import com.letscode.exemploaulabancodados.services.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContaServiceImpl implements ContaService {

    @Autowired
    private ContaRepository contaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public ContaResponse create(Integer id, ContaRequest contaRequest) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow();
        Conta novaConta = new Conta(contaRequest,usuario);
        contaRepository.save(novaConta);
        ContaResponse novaContaResponse = new ContaResponse(novaConta);
        return novaContaResponse;
    }
}
