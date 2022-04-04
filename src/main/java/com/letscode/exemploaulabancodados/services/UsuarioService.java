package com.letscode.exemploaulabancodados.services;

import com.letscode.exemploaulabancodados.dto.UsuarioRequest;
import com.letscode.exemploaulabancodados.dto.UsuarioResponse;
import com.letscode.exemploaulabancodados.models.Usuario;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UsuarioService {
    Page<Usuario> getAll(String nome, int page, int size);
//    Usuario create(UsuarioRequest usuarioRequest);

//    List<UsuarioResponse> getAll();
    UsuarioResponse create(UsuarioRequest usuarioRequest);
    UsuarioResponse getById(Integer id);
    Usuario update(UsuarioRequest usuarioRequest, Integer id);
    void delete(Integer id);

}
