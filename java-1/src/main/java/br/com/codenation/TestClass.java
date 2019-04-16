package br.com.codenation;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestClass {

    static DesafioMeuTimeApplication desafio;
    @BeforeAll
    static void init(){
        desafio = new DesafioMeuTimeApplication();
    }

    @Test
    void incluirTime(){
        desafio.incluirTime(1L, "Leonardo", LocalDate.now(), "Azul", "Branco");
        assertEquals(1L, desafio.buscarTimes().get(0));

    }
}
