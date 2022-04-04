package com.letscode.exemploaulabancodados.controller;

import com.letscode.exemploaulabancodados.dto.UsuarioRequest;
import com.letscode.exemploaulabancodados.dto.UsuarioResponse;
import com.letscode.exemploaulabancodados.models.Usuario;
import com.letscode.exemploaulabancodados.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

//    @GetMapping
//    public List<UsuarioResponse> getAll(){
//        return usuarioService.getAll();
//    }

    @PostMapping
    public UsuarioResponse create(@RequestBody UsuarioRequest usuarioRequest){
        return usuarioService.create(usuarioRequest);
    }

    @GetMapping("/{id}")
    public UsuarioResponse getById(@PathVariable("id") Integer id){
        return usuarioService.getById(id);
    }

    @PutMapping("/{id}")
    public Usuario update(@PathVariable Integer id, @RequestBody UsuarioRequest usuarioRequest){
        return usuarioService.update(usuarioRequest,id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        usuarioService.delete(id);
    }

      @GetMapping
    public Page<Usuario> getAll(@RequestParam(required = false) String nome,
                                @RequestParam(required = false, defaultValue = "0") int page,
                                @RequestParam(required = false, defaultValue = "3") int size){
        return usuarioService.getAll(nome,page,size);
    }
//
//    @PostMapping
//    public Usuario create(@RequestBody UsuarioRequest usuarioRequest){
//        return usuarioService.create(usuarioRequest);
//    }

}
