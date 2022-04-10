package com.letscode.exemploaulabancodados.dto;

import com.letscode.exemploaulabancodados.models.TipoTransacao;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransacaoRequest {

    @NotNull(message = "O valor não pode ser nulo")
    private BigDecimal valor;

    @NotBlank(message = "O tipo de transação não pode ser nulo nem branco")
    private TipoTransacao tipoTransacao;

    @NotNull(message = "O numero não pode ser nulo")
    private Integer numero;

    @NotNull(message = "A agencia não pode ser nulo")
    private Integer agencia;
//    private LocalDateTime dataCriacao;
//    private LocalDateTime dataAtualizacao;

}
