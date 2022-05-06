package exceptions;

import lombok.Data;

@Data
public class ValorInvalidoException extends Exception{

    private double numero;

    public ValorInvalidoException(String message, double numero) {
        super(message);
        this.numero = numero;
    }

}
