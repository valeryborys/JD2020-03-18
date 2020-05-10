package by.it.szamostyanin.Calc;

public class CalcException extends Exception {
    private static ResMan res = ConsoleRunner.getRes();

    public CalcException() {
        this(res.getString(ErrorMessages.ERROR_UNKNOWN));
    }

    public CalcException(String message) {
        super(res.getString(ErrorMessages.ERROR_ERROR)+message);
    }

    public CalcException(String message, Throwable cause) {
        super(res.getString(ErrorMessages.ERROR_ERROR)+message, cause);
    }

    public CalcException(Throwable cause) {
        this(res.getString(ErrorMessages.ERROR_UNKNOWN), cause);
    }
}