package com.letscode.exemploaulabancodados.projection;

import com.letscode.exemploaulabancodados.models.TipoTransacao;
import org.springframework.beans.factory.annotation.Value;

import java.math.BigDecimal;

public interface TransacaoView {

    BigDecimal getValor();

    TipoTransacao getTipoTransacao();

    @Value("#{target.numero + '-' + target.agencia}")
    String getNumeroAgenciaCompleto();
}
