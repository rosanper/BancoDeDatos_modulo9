package com.letscode.exemploaulabancodados.repositories;

import com.letscode.exemploaulabancodados.models.Conta;
import com.letscode.exemploaulabancodados.models.TipoConta;
import com.letscode.exemploaulabancodados.projection.ContaView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ContaRepository extends JpaRepository<Conta,Integer> {

    List<Conta> findByAgenciaOrNumero(Integer agencia, Integer numero);

    Page<Conta> findBySaldoGreaterThan(BigDecimal saldo, Pageable pageRequest);

    List<ContaView> findByTipoContaOrderByDataCriacao(TipoConta tipoConta);

    @Query("select c from Conta c " +
            "where c.tipoConta = :tipoConta and c.usuario.nome = :nome")
    List<Conta> findByTipoContaAndUsuarioName(
            @Param("tipoConta") TipoConta tipoConta,
            @Param("nome") String nome
    );


}
