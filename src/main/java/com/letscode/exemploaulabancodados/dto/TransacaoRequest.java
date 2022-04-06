package com.letscode.exemploaulabancodados.dto;

import com.letscode.exemploaulabancodados.models.TipoTransacao;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransacaoRequest {

    private BigDecimal valor;
    private TipoTransacao tipoTransacao;
    private Integer numero;
    private Integer agencia;
//    private LocalDateTime dataCriacao;
//    private LocalDateTime dataAtualizacao;

}
