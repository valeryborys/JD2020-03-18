package by.it.borys.calc;

public class CalcExeption extends Exception {
    public CalcExeption() {
        this("ERROR: unknown error");
    }

    public CalcExeption(String message) {
        super("ERROR: "+message);
    }

    public CalcExeption(String message, Throwable cause) {
        super("ERROR: "+message, cause);
    }

    public CalcExeption(Throwable cause) {
        this("ERROR: unknown error", cause);
    }
}
