package challenge;
import java.nio.charset.StandardCharsets;

public class CriptografiaCesariana implements Criptografia {

    private final int N_CASAS = 3;
    private final int N_LETRAS = 26;
    private final int LETRA1 = 97;
    private final int LETRA26 = 122;

    @Override
    public String criptografar(String texto) {
        if(texto == null){
            throw new NullPointerException();
        }
        else if(texto.isEmpty()){
            throw new IllegalArgumentException();
        }
        texto = texto.toLowerCase();
        byte [] bytes = texto.getBytes();
        for(int i = 0; i < bytes.length; i++){
            int letra = bytes[i];
            if(letra >= LETRA1 && letra <= LETRA26 - N_CASAS) {
                bytes[i] = (byte) (Byte.toUnsignedInt(bytes[i]) + N_CASAS);
            } else if(letra > LETRA26 - N_CASAS && letra <= LETRA26){
                bytes[i] = (byte) (Byte.toUnsignedInt(bytes[i]) + N_CASAS - N_LETRAS);
            } else {
                bytes[i] = (byte) (Byte.toUnsignedInt(bytes[i]));
            }
        }
        return new String(bytes, StandardCharsets.UTF_8);
    }

    @Override
    public String descriptografar(String texto) {
        if(texto == null){
            throw new NullPointerException();
        }
        else if(texto.isEmpty()){
            throw new IllegalArgumentException();
        }
        texto = texto.toLowerCase();
        byte [] bytes = texto.getBytes();
        for(int i = 0; i < bytes.length; i++){
            int letra = bytes[i];
            if(letra >= LETRA1 + N_CASAS && letra <= LETRA26) {
                bytes[i] = (byte) (Byte.toUnsignedInt(bytes[i]) - N_CASAS);
            } else if(letra >= LETRA1 && letra < LETRA1 + N_CASAS){
                bytes[i] = (byte) (Byte.toUnsignedInt(bytes[i]) - N_CASAS + N_LETRAS);
            } else {
                bytes[i] = (byte) (Byte.toUnsignedInt(bytes[i]));
            }
        }
        return new String(bytes, StandardCharsets.UTF_8);
    }
}
