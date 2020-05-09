package by.it.bobrovich.calc;

public class CalcException extends Exception {
    public CalcException() {
    }

    public CalcException(String message) {
        super(ResMan.getString(Message.errorMessage) + " " + message);
    }

    public CalcException(String message, Throwable cause) {
        super(ResMan.getString(Message.errorMessage) + " " + message);
    }

    public CalcException(Throwable cause) {
        super(ResMan.getString(Message.errorMessage) + " " +  cause);
    }

    public CalcException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(ResMan.getString(Message.errorMessage) + " " +  message, cause, enableSuppression, writableStackTrace);
    }
}
