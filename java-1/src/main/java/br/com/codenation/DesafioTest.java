package br.com.codenation;

import br.com.codenation.desafio.exceptions.IdentificadorUtilizadoException;
import br.com.codenation.desafio.exceptions.TimeNaoEncontradoException;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.Executable;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DesafioTest {

    private DesafioMeuTimeApplication desafio;

    @BeforeEach
    public void init(){
        desafio = new DesafioMeuTimeApplication();
    }

    @Test
    @DisplayName("Deve add time normalmente")
    public void deveIncluirTimeNormalmente(){
        desafio.incluirTime(1L, "time1", LocalDate.now(), "azul", "branco");
        assertEquals(1, desafio.getTimeList().size());
        desafio.incluirTime(2L, "time2", LocalDate.now(), "azul", "branco");
        assertEquals(2, desafio.getTimeList().size());
    }

    @Test
    @DisplayName("Deve dar erro ao add time")
    public void deveDarErroAoIncluirTime(){
        desafio.incluirTime(1L, "time1", LocalDate.now(), "azul", "branco");
        assertThrows(IdentificadorUtilizadoException.class, () ->
                desafio.incluirTime(1L, "time1", LocalDate.now(), "azul", "branco"));
    }

    @Test
    @DisplayName("Deve dar erro ao add jogador em time que não existe")
    public void erroTimeNuloAoAddJogador(){
        Executable incluirJogador = () -> desafio.incluirJogador(1L, 1L, "jogador1", LocalDate.now(), 5, BigDecimal.valueOf(1000));
        assertThrows(TimeNaoEncontradoException.class, incluirJogador);
    }

    @Test
    @DisplayName("Deve dar erro ao add jogador com id existente")
    public void erroIdExistenteAoAddJogador(){
        desafio.incluirTime(1L, "time1", LocalDate.now(), "azul", "branco");
        desafio.incluirJogador(1L, 1L, "jogador1", LocalDate.now(), 5, BigDecimal.valueOf(1000));
        Executable incluirJogador2 = () -> desafio.incluirJogador(1L, 1L, "jogador2", LocalDate.now(), 5, BigDecimal.valueOf(1000));
        assertThrows(IdentificadorUtilizadoException.class, incluirJogador2);
    }

    @Test
    @DisplayName("Deve add jogador normalmente")
    public void addJogadorSemErros(){
        desafio.incluirTime(1L, "time1", LocalDate.now(), "azul", "branco");
        desafio.incluirJogador(1L, 1L, "jogador1", LocalDate.now(), 5, BigDecimal.valueOf(1000));
        assertEquals(1, desafio.getTimeList().get(0).getJogadorList().size());
    }
}
