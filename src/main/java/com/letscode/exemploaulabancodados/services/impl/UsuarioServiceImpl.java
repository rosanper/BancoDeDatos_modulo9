package com.letscode.exemploaulabancodados.services.impl;

import com.letscode.exemploaulabancodados.dto.UsuarioRequest;
import com.letscode.exemploaulabancodados.dto.UsuarioResponse;
import com.letscode.exemploaulabancodados.exceptions.ErroNotFind;
import com.letscode.exemploaulabancodados.models.Usuario;
import com.letscode.exemploaulabancodados.repositories.UsuarioRepository;
import com.letscode.exemploaulabancodados.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public Page<Usuario> getAll(String nome, int page, int size) {

        PageRequest pageRequest = PageRequest.of(
                page, size, Sort.Direction.ASC,"nome"
        );

        if(nome != null){
            return usuarioRepository.findByNome(nome, pageRequest);
        }else{
            return usuarioRepository.findAll(pageRequest);
        }

    }

    @Override
    public UsuarioResponse create(UsuarioRequest usuarioRequest) {
        Usuario usuario = new Usuario(usuarioRequest);
        usuarioRepository.save(usuario);
        return new UsuarioResponse(usuario);
    }

    @Override
    public UsuarioResponse getById(Integer id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new ErroNotFind("Não existe Usuário com esse id"));
        UsuarioResponse usuarioResponse = new UsuarioResponse(usuario);
        return usuarioResponse;
    }

    @Override
    public Usuario update(UsuarioRequest usuarioRequest, Integer id) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow();
        usuario.setNome(usuarioRequest.getNome());
        usuario.setCpf(usuarioRequest.getCpf());
        usuario.setSenha(usuarioRequest.getSenha());
        usuario.setDataAtualizacao(LocalDateTime.now());

        usuarioRepository.save(usuario);

        return usuario;
    }

    @Override
    public void delete(Integer id) {
        var usuario = usuarioRepository.findById(id).orElseThrow();
        usuarioRepository.delete(usuario);
    }
}
