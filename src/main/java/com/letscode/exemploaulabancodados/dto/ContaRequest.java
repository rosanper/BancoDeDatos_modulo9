package com.letscode.exemploaulabancodados.dto;

import com.letscode.exemploaulabancodados.models.TipoConta;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContaRequest {
    @NotNull(message = "O número não pode ser nulo")
    private Integer numero;

    @NotNull(message = "O número não pode ser nulo")
    private Integer agencia;

    @NotNull(message = "O número não pode ser nulo")
    private BigDecimal saldo;

    @NotNull(message = "O tipo de transação não pode ser nulo")
    private TipoConta tipoConta;

}
