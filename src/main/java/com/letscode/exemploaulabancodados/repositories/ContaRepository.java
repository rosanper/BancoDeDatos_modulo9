package com.letscode.exemploaulabancodados.repositories;

import com.letscode.exemploaulabancodados.models.Conta;
import com.letscode.exemploaulabancodados.models.TipoConta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ContaRepository extends JpaRepository<Conta,Integer> {
//    List<Conta> findBySaldoLessThan(BigDecimal saldo);
//    List<Conta> findBySaldoLessThanEqual(BigDecimal saldo);
//    List<Conta> findBySaldoGreaterThan(BigDecimal saldo);
//    List<Conta> findBySaldoGreaterThanEqual(BigDecimal saldo);
//
//    boolean existsByTipoConta(TipoConta tipoConta);
}
