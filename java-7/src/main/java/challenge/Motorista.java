package challenge;

public class Motorista {

    private int idade;
    private String habilitacao;
    private int pontos;
    private String nome;

    public Motorista(Integer idade, String habilitacao, Integer pontos, String nome) {
        if(habilitacao == null || nome == null){
            throw new NullPointerException("Habilitação e nome não devem ser nulos!");
        }
        this.idade = idade;
        this.habilitacao = habilitacao;
        this.pontos = pontos;
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getHabilitacao() {
        return habilitacao;
    }

    public int getPontos() {
        return pontos;
    }

    public String getNome() {
        return nome;
    }

    public static MotoristaBuilder builder(){
        return new MotoristaBuilder();
    }
}
