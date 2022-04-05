package com.letscode.exemploaulabancodados.dto;

import com.letscode.exemploaulabancodados.models.TipoTransacao;
import com.letscode.exemploaulabancodados.models.Transacao;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransacaoResponse {

    private Integer id;
    private BigDecimal valor;
    private TipoTransacao tipoTransacao;
    private Integer numero;
    private Integer agencia;

    public TransacaoResponse(Transacao transacao){
        this.id = transacao.getId();
        this.valor = transacao.getValor();
        this.tipoTransacao = transacao.getTipoTransacao();
        this.numero = transacao.getNumero();
        this.agencia = transacao.getAgencia();
    }


}
