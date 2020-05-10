package by.it.okatov.calc;

import by.it.okatov.calc.globalization.IError;
import by.it.okatov.calc.globalization.ResourceManager;

import static by.it.okatov.calc.ConsoleRunner.baos;
import static by.it.okatov.calc.ConsoleRunner.logSystem;


public class CalcException extends Exception {
    static ResourceManager manager = ResourceManager.INSTANCE;

    public CalcException() {
        this(manager.getString(IError.msgErrorUnknown));
        logSystem.createLog(baos.toString());
    }

    public CalcException(String message) {
        super(manager.getString(IError.msgErrorError) + message);
        logSystem.createLog(baos.toString());
    }

    public CalcException(String message, Throwable cause) {
        super(manager.getString(IError.msgErrorError) + message + cause);
        logSystem.createLog(baos.toString());
    }

    public CalcException(Throwable cause) {
        this(manager.getString(IError.msgErrorUnknown) + cause);
        logSystem.createLog(baos.toString());
    }
}
