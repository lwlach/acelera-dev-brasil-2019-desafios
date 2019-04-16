package challenge;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class Estacionamento {

    private final int idadeMinima = 18;
    private final int pontosMaximo = 20;

    private int vagas;
    private List<Carro> carros;

    private void validaCarro(Carro carro){
        if(carro.getMotorista() == null){
            throw new EstacionamentoException("Carro não pode ser autonomo!");
        }
        if(carro.getMotorista().getIdade() < idadeMinima){
            throw new EstacionamentoException("Motorista deve ser maior de idade!");
        }
        if(carro.getMotorista().getPontos() > pontosMaximo){
            throw new EstacionamentoException("Motorista não pode ter mais de 20 pontos da carteira!");
        }
    }

    private void tentaRemoverCarro(){
        Optional<Carro> carroQueDeveSair = carros.stream()
                .filter(c -> c.getMotorista().getIdade() < 55)
                .findFirst();
        if(!carroQueDeveSair.isPresent()) {
            throw new EstacionamentoException("Nenhuma vaga disponível!");
        }
        carros.remove(carroQueDeveSair.get());
    }

    public Estacionamento() {
        this.vagas = 10;
        this.carros = new LinkedList<>();
    }

    public void estacionar(Carro carro) {
        validaCarro(carro);
        if(vagas == 0) {
            tentaRemoverCarro();
        }
        carros.add(carro);
        vagas--;
    }

    public int carrosEstacionados() {
        return carros.size();
    }

    public boolean carroEstacionado(Carro carro) {
        return carros.contains(carro);
    }

}
