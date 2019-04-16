package challenge;

import java.io.UnsupportedEncodingException;

public class MainTeste {

    public static void main(String[] args) {
        String texto = "teste";
        String criptografado = "";
        texto = texto.toLowerCase();
        byte [] bytes = texto.getBytes();
        for(int i = 0; i < bytes.length; i++){
            bytes[i] = (byte) (Byte.toUnsignedInt(bytes[i]) + 3);
        }
        try {
            criptografado = new String(bytes, "UTF-8");
        } catch (UnsupportedEncodingException e){
            criptografado = "";
        }
        System.out.println(criptografado);
    }
}
