package com.letscode.exemploaulabancodados.repositories;

import com.letscode.exemploaulabancodados.models.Conta;
import com.letscode.exemploaulabancodados.models.TipoConta;
import com.letscode.exemploaulabancodados.models.Usuario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@DataJpaTest
class ContaRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private ContaRepository contaRepository;

    @Test
    public void validar_findAll_se_estiver_vazio(){
         var contas = contaRepository.findAll();
        Assertions.assertTrue(contas.isEmpty());
    }

    @Test
    public void validar_findAll_se_nao_estiver_vazio(){

        Conta conta = newConta();
        testEntityManager.persist(conta);

        var contas = contaRepository.findAll();
        Assertions.assertEquals(Arrays.asList(conta),contas);
    }

    @Test
    public void trazer_conta_pelo_id(){
        Conta conta = newConta();
        testEntityManager.persist(conta);

        var contaObtida = contaRepository.findById(1).get();
        Assertions.assertEquals(contaObtida,conta);
    }

    @Test
    public void falhar_trazer_conta_pelo_id_errado(){
        Conta conta = newConta();
        testEntityManager.persist(conta);

        var contaObtida = contaRepository.findById(2).orElse(null);
        Assertions.assertNull(contaObtida);
    }

    @Test
    public void falhar_trazer_conta_pelo_id_lista_vazia(){

        var contaObtida = contaRepository.findById(1).orElse(null);
        Assertions.assertNull(contaObtida);
    }

    @Test
    public void sucesso_ao_atualizar_conta(){
        Conta conta = newConta();
        testEntityManager.persist(conta);

        Integer novaAgencia = 66666;
        conta.setAgencia(novaAgencia);
        contaRepository.save(conta);

        var contas = contaRepository.findAll();
        Assertions.assertEquals(contas.stream().findFirst().get().getAgencia(),novaAgencia);
    }

    @Test
    public void obter_contas_com_saldo_maior_que_milEQuinhentos(){
        Conta conta1 = newConta();
        Conta conta2 = newConta(TipoConta.PF,BigDecimal.valueOf(2000.00),9999,5555);

        testEntityManager.persist(conta1);
        testEntityManager.persist(conta2);

        PageRequest pageRequest = PageRequest.of(0,3);

        Page<Conta> contas = contaRepository.findBySaldoGreaterThan(BigDecimal.valueOf(1500.00), pageRequest);

        Assertions.assertEquals(1,contas.getTotalElements());
        Assertions.assertEquals(conta2,contas.stream().findFirst().get());
    }

    @Test
    public void sucesso_ao_trazer_usuario_pelo_tipoConta_e_nomeUsuario(){
        Conta conta1 = newConta();
        Conta conta2 = newConta(TipoConta.PF,BigDecimal.valueOf(2000.00),9999,5555);

        Usuario usuario1 = new Usuario();
        usuario1.setNome("Carlos");
        usuario1.setCpf("212112");
        usuario1.setSenha("1212");

        conta1.setUsuario(usuario1);
        conta2.setUsuario(usuario1);

        testEntityManager.persist(usuario1);

        testEntityManager.persist(conta1);
        testEntityManager.persist(conta2);


        var contas = contaRepository.findByTipoContaAndUsuarioName(TipoConta.PF,"Carlos");

        Assertions.assertEquals(Arrays.asList(conta1,conta2),contas);
    }

    @Test
    public void falha_ao_trazer_usuario_pelo_tipoConta_errado_e_nomeUsuario(){
        Conta conta1 = newConta();
        Conta conta2 = newConta(TipoConta.PF,BigDecimal.valueOf(2000.00),9999,5555);

        Usuario usuario1 = new Usuario();
        usuario1.setNome("Carlos");
        usuario1.setCpf("212112");
        usuario1.setSenha("1212");

        conta1.setUsuario(usuario1);
        conta2.setUsuario(usuario1);

        testEntityManager.persist(usuario1);

        testEntityManager.persist(conta1);
        testEntityManager.persist(conta2);


        var contas = contaRepository.findByTipoContaAndUsuarioName(TipoConta.PJ,"Carlos");

        Assertions.assertTrue(contas.isEmpty());
        // Assertions.assertNotEquals(Arrays.asList(conta1,conta2),contas);
    }

    @Test
    public void falha_ao_trazer_usuario_pelo_tipoConta_e_nomeUsuario_errado(){
        Conta conta1 = newConta();
        Conta conta2 = newConta(TipoConta.PF,BigDecimal.valueOf(2000.00),9999,5555);

        Usuario usuario1 = new Usuario();
        usuario1.setNome("Carlos");
        usuario1.setCpf("212112");
        usuario1.setSenha("1212");

        conta1.setUsuario(usuario1);
        conta2.setUsuario(usuario1);

        testEntityManager.persist(usuario1);

        testEntityManager.persist(conta1);
        testEntityManager.persist(conta2);


        var contas = contaRepository.findByTipoContaAndUsuarioName(TipoConta.PF,"Maria");

        Assertions.assertTrue(contas.isEmpty());
        // Assertions.assertNotEquals(Arrays.asList(conta1,conta2),contas);
    }




    private Conta newConta(){
        Conta conta = new Conta();
        conta.setTipoConta(TipoConta.PF);
        conta.setSaldo(BigDecimal.valueOf(1000.00));
        conta.setNumero(4545);
        conta.setAgencia(111);
        return conta;
    }

    private Conta newConta(TipoConta tipoConta,BigDecimal saldo, Integer numero, Integer agencia){
        Conta conta = new Conta();
        conta.setTipoConta(tipoConta);
        conta.setSaldo(saldo);
        conta.setNumero(numero);
        conta.setAgencia(agencia);
        return conta;
    }

}