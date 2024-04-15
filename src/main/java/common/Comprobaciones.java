package common;

public class Comprobaciones {
    public static boolean caracterValido(char entrada) {
        if (Character.isAlphabetic(entrada)) {
            return true;
        } else if (entrada == '+' || entrada == '-') {
            return true;
        }
        return false;
    }

    public static void comprobarCaracter(String entrada) throws InputInvalidoException {
        if (entrada.length() != 1) {
            throw new InputInvalidoException();
        } else {
            if (!Character.isAlphabetic(entrada.charAt(0)) && !entrada.equals("+") && !entrada.equals("-")) {
                throw new InputInvalidoException();
            }
        }
    }
}
