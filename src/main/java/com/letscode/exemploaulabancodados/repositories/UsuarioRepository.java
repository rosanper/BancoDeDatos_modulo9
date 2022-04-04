package com.letscode.exemploaulabancodados.repositories;

import com.letscode.exemploaulabancodados.models.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;




@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {
    Page<Usuario> findByNome(String nome, Pageable pageRequest);

//    List<Usuario> findByNomeAndCpf(String nome, String cpf);
//
//    List<Usuario> findByNomeIs(String nome);
//    List<Usuario> findByNomeIsNot(String nome);
//
//    List<Usuario> findByNomeIsNull();
//    List<Usuario> findByNomeIsNotNull();
//
//    List<Usuario> findByCpfStartingWith(String cpf);
//    List<Usuario> findByCpfEndingWith(String cpf);
//    List<Usuario> findByCpfContaining(String cpf);
//
//    List<Usuario> findByNomeLike(String pattern);
//
//    List<Usuario> findByDataCriacaoAfter(LocalDateTime dataCriacao);
//    List<Usuario> findByDataCriacaoAfterAndNome(LocalDateTime dataCriacao, String nome);
//    List<Usuario> findByDataCriacao(LocalDateTime dataCriacao);
//
//    List<Usuario> findByNomeOrderByNome(String nome);
//    List<Usuario> findByNomeAndAndDataCriacaoOrderByNome(String nome);


//    List<Usuario> findByAtivoTrue();
//    List<Usuario> findByAtivoFalse();

}
