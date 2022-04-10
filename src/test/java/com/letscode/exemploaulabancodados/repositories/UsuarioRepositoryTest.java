package com.letscode.exemploaulabancodados.repositories;

import com.letscode.exemploaulabancodados.models.Usuario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Arrays;


@ActiveProfiles("test")
@DataJpaTest
class UsuarioRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Test
    public void validar_findAll_vazio_se_repositorio_em_branco(){
        var usuarios = usuarioRepository.findAll();

        Assertions.assertEquals(Arrays.asList(),usuarios);
    }

    @Test
    public void trazer_usuario_cadastrado_no_findAll(){
        Usuario usuario1 = new Usuario();
        usuario1.setNome("Carlos");
        usuario1.setCpf("212112");
        usuario1.setSenha("1212");

        Usuario usuario2 = new Usuario();
        usuario2.setNome("Carla");
        usuario2.setCpf("4545454");
        usuario2.setSenha("4545");

        testEntityManager.persist(usuario1);
        testEntityManager.persist(usuario2);

        var usuarios = usuarioRepository.findAll();
        Assertions.assertEquals(Arrays.asList(usuario1,usuario2),usuarios);
    }

    @Test
    public void trazer_usuario_pelo_nome_com_sucesso(){
        Usuario usuario1 = new Usuario();
        usuario1.setNome("Carlos");
        usuario1.setCpf("212112");
        usuario1.setSenha("1212");

        Usuario usuario2 = new Usuario();
        usuario2.setNome("Carla");
        usuario2.setCpf("4545454");
        usuario2.setSenha("4545");

        testEntityManager.persist(usuario1);
        testEntityManager.persist(usuario2);

        PageRequest pageRequest = PageRequest.of(0,3);

        var usuarios = usuarioRepository.findByNome("Carlos",pageRequest);

        Assertions.assertEquals(1,usuarios.getTotalElements());
        Assertions.assertEquals(usuario1,usuarios.stream().findFirst().get());
    }

    @Test
    public void alterar_usuario(){
        Usuario usuario1 = new Usuario();
        usuario1.setNome("Carlos");
        usuario1.setCpf("212112");
        usuario1.setSenha("1212");

        testEntityManager.persist(usuario1);

        usuario1.setNome("Carllos");

        usuarioRepository.save(usuario1);
        var usuarios = usuarioRepository.findAll();

        Assertions.assertEquals(usuario1,usuarios.stream().findFirst().get());

    }
}