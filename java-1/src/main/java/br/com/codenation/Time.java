package br.com.codenation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Time {

    private Long id;
    private String nome;
    private LocalDate dataCriacao;
    private String corUniformePrincipal;
    private String corUniformeSecundario;

    private Jogador capitao;
    private List<Jogador> jogadorList;

    public Time(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal, String corUniformeSecundario) {
        this.id = id;
        this.nome = nome;
        this.dataCriacao = dataCriacao;
        this.corUniformePrincipal = corUniformePrincipal;
        this.corUniformeSecundario = corUniformeSecundario;
        this.jogadorList = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCorUniformePrincipal() {
        return corUniformePrincipal;
    }

    public String getCorUniformeSecundario() {
        return corUniformeSecundario;
    }

    public List<Jogador> getJogadorList() {
        return jogadorList;
    }

    public void addJogador(Jogador jogador){
        jogadorList.add(jogador);
    }

    public Jogador getJogador(Long idJogador){
        return jogadorList.stream()
                .filter(jogador -> idJogador.equals(jogador.getId()))
                .findAny()
                .orElse(null);
    }

    public Jogador getCapitao() {
        return capitao;
    }

    public void setCapitao(Jogador capitao) {
        this.capitao = capitao;
    }
}
