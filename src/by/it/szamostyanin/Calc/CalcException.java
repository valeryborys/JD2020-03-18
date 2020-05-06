package by.it.szamostyanin.Calc;

public class CalcException extends Exception {
    public CalcException() {
        this("ERROR: unknown");
    }

    public CalcException(String message) {
        super("ERROR: "+message);
    }

    public CalcException(String message, Throwable cause) {
        super("ERROR: "+message, cause);
    }

    public CalcException(Throwable cause) {
        this("ERROR: unknown", cause);
    }
}