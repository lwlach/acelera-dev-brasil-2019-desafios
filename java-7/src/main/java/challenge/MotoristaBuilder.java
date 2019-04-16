package challenge;

public class MotoristaBuilder {
    private int idade;
    private String habilitacao;
    private int pontos;
    private String nome;

    public MotoristaBuilder withIdade(int idade) {
        if(idade < 0){
            throw new IllegalArgumentException("Idade deve ser positiva!");
        }
        this.idade = idade;
        return this;
    }

    public MotoristaBuilder withHabilitacao(String habilitacao) {
        this.habilitacao = habilitacao;
        return this;
    }

    public MotoristaBuilder withPontos(int pontos) {
        if(pontos < 0){
            throw new IllegalArgumentException("Pontos da carteira devem ser positivos!");
        }
        this.pontos = pontos;
        return this;
    }

    public MotoristaBuilder withNome(String nome) {
        this.nome = nome;
        return this;
    }

    public Motorista build() {
        return new Motorista(idade, habilitacao, pontos, nome);
    }
}