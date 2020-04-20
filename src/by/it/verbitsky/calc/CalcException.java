package by.it.verbitsky.calc;

//В боевой версии лучше наследоваться от uncheked (RuntimeExc)
//Для примера и общего понятия наследуемся от checked Exc

class CalcException extends Exception {
    public CalcException() {
        this("ERROR: unknown error");
    }

    public CalcException(String message) {
        super("ERROR: " + message);
    }

    public CalcException(String message, Throwable cause) {
        super("ERROR: " + message, cause);
    }

    public CalcException(Throwable cause) {
        this("ERROR: unknown error", cause);
    }
}
