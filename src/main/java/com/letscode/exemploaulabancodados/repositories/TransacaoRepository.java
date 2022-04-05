package com.letscode.exemploaulabancodados.repositories;

import com.letscode.exemploaulabancodados.models.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Integer> {
}
