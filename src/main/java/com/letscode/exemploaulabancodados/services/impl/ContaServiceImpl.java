package com.letscode.exemploaulabancodados.services.impl;

import com.letscode.exemploaulabancodados.dto.ContaRequest;
import com.letscode.exemploaulabancodados.dto.ContaResponse;
import com.letscode.exemploaulabancodados.models.Conta;
import com.letscode.exemploaulabancodados.models.TipoConta;
import com.letscode.exemploaulabancodados.models.Usuario;
import com.letscode.exemploaulabancodados.projection.ContaView;
import com.letscode.exemploaulabancodados.repositories.ContaRepository;
import com.letscode.exemploaulabancodados.repositories.UsuarioRepository;
import com.letscode.exemploaulabancodados.services.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

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

    @Override
    public List<Conta> getAll() {
        return contaRepository.findAll();
    }

    @Override
    public Conta getById(Integer id) {
        return contaRepository.findById(id).orElseThrow(); // criar exception
    }

    @Override
    public Conta update(ContaRequest contaRequest, Integer id) {
        Conta conta = getById(id);
        conta.setAgencia(contaRequest.getAgencia());
        conta.setTipoConta(contaRequest.getTipoConta());
        conta.setNumero(contaRequest.getNumero());
        conta.setSaldo(contaRequest.getSaldo());
        conta.setDataAtualizacao(LocalDateTime.now());  //Ajustar a data de atualizacao nos outros services tbm.

        contaRepository.save(conta);

        return conta;
    }

    @Override
    public void delete(Integer id) {       // corrigir - Também está deletando o usuario
        Conta conta = getById(id);
        contaRepository.delete(conta);
    }

    @Override
    public List<Conta> getByUsuario(String cpf, String nome, Integer agencia) {
        return null;
//        return contaRepository.findByUsuarioCpfOrUsuarioNomeAndAgencia(cpf,nome,agencia);
    }

    @Override
    public Page<Conta> getContasSaldoGreaterThan(BigDecimal valor, int page, int size) {
        PageRequest pageRequest = PageRequest.of(page,size);
        return contaRepository.findBySaldoGreaterThan(valor,pageRequest);
    }

    @Override
    public List<ContaView> getByTipoConta(TipoConta tipoConta){
        return contaRepository.findByTipoContaOrderByDataCriacao(tipoConta);
    }

//    public List<Conta> teste(Integer agencia, Integer numero){
//        return contaRepository.findByAgenciaOrNumero(agencia, numero);
//    }

    public List<Conta> getByQuery(TipoConta tipoConta, String nome){
        return contaRepository.findByTipoContaAndUsuarioName(tipoConta, nome);
    }
}
