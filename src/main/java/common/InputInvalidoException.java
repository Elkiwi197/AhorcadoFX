package common;

public class InputInvalidoException extends Exception{

    public InputInvalidoException(){
        super("Introduce un carácter válido");
    }
}
