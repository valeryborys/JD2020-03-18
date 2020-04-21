package by.it.gutkovsky.calc;

class CalcException extends Exception{
    public CalcException() {
//        super();
        this("ERROR: unknown error");
    }

    public CalcException(String message) {
        super("ERROR: " + message);
    }

    public CalcException(String message, Throwable cause) {
        super("ERROR: " + message, cause);
    }

    public CalcException(Throwable cause) {
//        super("ERROR: " + cause);
        this("ERROR: unknown error" + cause);
    }
}
