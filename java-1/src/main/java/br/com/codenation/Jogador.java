package br.com.codenation;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Jogador {

    private Long id;
    private Long idTime;
    private String nome;
    private LocalDate dataNascimento;
    private Integer nivelHabilidade;
    private BigDecimal salario;

    public Jogador(Long id, Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salario) {
        this.id = id;
        this.idTime = idTime;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.setNivelHabilidade(nivelHabilidade);
        this.salario = salario;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public Integer getNivelHabilidade() {
        return nivelHabilidade;
    }


    public void setNome(String nome){
        this.nome = nome;
    }

    private void setNivelHabilidade(Integer nivelHabilidade) {
        if(nivelHabilidade > 100) {
            this.nivelHabilidade = 100;
        } else if(nivelHabilidade < 0){
            this.nivelHabilidade = 0;
        } else {
            this.nivelHabilidade = nivelHabilidade;
        }
    }

    public BigDecimal getSalario() {
        return salario;
    }

    @Override
    public String toString() {
        return "Jogador{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", nivelHabilidade=" + nivelHabilidade +
                '}';
    }
}
