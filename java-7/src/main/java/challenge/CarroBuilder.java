package challenge;

public class CarroBuilder {
    private String placa;
    private Cor cor;
    private Motorista motorista;

    public CarroBuilder withPlaca(String placa) {
        this.placa = placa;
        return this;
    }

    public CarroBuilder withCor(Cor cor) {
        this.cor = cor;
        return this;
    }

    public CarroBuilder withMotorista(Motorista motorista) {
        this.motorista = motorista;
        return this;
    }

    public Carro build() {
        return new Carro(placa, cor, motorista);
    }
}