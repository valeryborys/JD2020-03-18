package by.it.gutkovsky.calc;

class CalcException extends Exception {
    public CalcException() {
//        this("ERROR: unknown error");
        this(ConsoleRunner.res.get(CalcExceptionMessage.fullMessage));
    }

    public CalcException(String message) {
//        super("ERROR: " + message);
        super(ConsoleRunner.res.get(CalcExceptionMessage.shortMessage) + " " + message);
    }

    public CalcException(String message, Throwable cause) {
//        super("ERROR: " + message, cause);
        super(ConsoleRunner.res.get(CalcExceptionMessage.shortMessage) + " " + message, cause);
    }

    public CalcException(Throwable cause) {
//        super("ERROR: " + cause);
//        this("ERROR: unknown error" + cause);
        this(ConsoleRunner.res.get(CalcExceptionMessage.fullMessage) + " " + cause);
    }
}
