package com.letscode.exemploaulabancodados.projection;

import com.letscode.exemploaulabancodados.models.TipoConta;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDateTime;
import java.util.List;

public interface ContaView {

    Integer getSaldo();

    TipoConta getTipoConta();

    LocalDateTime getDataCriacao();

    @Value("#{target.numero + '-' + target.agencia}")
    String getNumeroAgenciaCompleto();

    UsuarioView getUsuario();

    List<TransacaoView> getTransacoes();
}
