package by.it.verbitsky.calc;

//В боевой версии лучше наследоваться от uncheked (RuntimeExc)
//Для примера и общего понятия наследуемся от checked Exc

class CalcException extends Exception {
    private static ResourceManager rm = ConsoleRunner.getRm();
    public CalcException() {
        this(rm.getMessage(CalcMessages.SYSTEM_ERROR_UNKNOWN_ERROR));
    }

    public CalcException(String message) {
        super(rm.getMessage(CalcMessages.SYSTEM_ERROR_EMPTY_ERROR) + message);
    }

    public CalcException(String message, Throwable cause) {
        super(rm.getMessage(CalcMessages.SYSTEM_ERROR_EMPTY_ERROR) + message, cause);
    }

    public CalcException(Throwable cause) {
        this(rm.getMessage(CalcMessages.SYSTEM_ERROR_UNKNOWN_ERROR), cause);
    }
}
