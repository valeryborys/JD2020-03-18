package by.it.lemesh.calc;

public class CalcException extends Exception {
    static ResMan res = ResMan.INSTANCE;
    public CalcException() {
    }

    public CalcException(String message) {
        super(res.get(Messages.ERROR_ERROR) + message);
    }

    public CalcException(String message, Throwable cause) {
        super(res.get(Messages.ERROR_ERROR) + message, cause);
    }

    public CalcException(Throwable cause) {
        super(cause);
    }
}
