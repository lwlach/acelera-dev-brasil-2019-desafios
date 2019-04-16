package challenge;

public class Carro {

    private String placa;
    private Cor cor;
    private Motorista motorista;

    public Carro(String placa, Cor cor, Motorista motorista) {
        if(placa == null || cor == null){
            throw new NullPointerException("Carro precisa ter placa e cor!");
        }
        this.placa = placa;
        this.cor = cor;
        this.motorista = motorista;
    }

    public String getPlaca() {
        return placa;
    }

    public Cor getCor() {
        return cor;
    }

    public Motorista getMotorista() {
        return motorista;
    }

    public static CarroBuilder builder(){
        return new CarroBuilder();
    }

}
