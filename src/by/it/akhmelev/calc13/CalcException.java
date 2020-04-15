package by.it.akhmelev.calc13;

public class CalcException extends Exception{
    public CalcException() {
        this("ERROR: unknown error");
    }

    public CalcException(String message) {
        super("ERROR: "+message);
    }

    public CalcException(String message, Throwable cause) {
        super("ERROR: "+message, cause);
    }

    public CalcException(Throwable cause) {
        this("ERROR: unknown error", cause);
    }
}
