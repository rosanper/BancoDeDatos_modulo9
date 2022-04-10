package com.letscode.exemploaulabancodados.dto;

import com.letscode.exemploaulabancodados.models.Conta;
import com.letscode.exemploaulabancodados.models.TipoConta;
import com.letscode.exemploaulabancodados.models.Transacao;
import lombok.*;



import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ContaResponse {
    private Integer numero;
    private Integer agencia;
    private BigDecimal saldo;
    private TipoConta tipoConta;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;
    private UsuarioResponse usuario;
    private List<TransacaoResponse> transacoes;

    public ContaResponse(Conta conta) {
        this.numero = conta.getNumero();
        this.agencia = conta.getAgencia();
        this.saldo = conta.getSaldo();
        this.tipoConta = conta.getTipoConta();
        this.dataCriacao = conta.getDataCriacao();
        this.dataAtualizacao = conta.getDataAtualizacao();
        this.usuario = new UsuarioResponse(conta.getUsuario());
        this.transacoes = (conta.getTransacoes() == null) ? null : conta.getTransacoes().stream()
                .map(transacao -> new TransacaoResponse(transacao)).collect(Collectors.toList());
    }
}
