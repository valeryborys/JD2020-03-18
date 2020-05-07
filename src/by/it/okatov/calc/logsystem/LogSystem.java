package by.it.okatov.calc.logsystem;

import java.io.PrintStream;

public class LogSystem extends PrintStream implements ILogSystem {

    PrintStream out;

    public LogSystem(PrintStream consoleOut, PrintStream loggerOut) {
        super(consoleOut);
        this.out = loggerOut;
    }

    @Deprecated
    @Override
    public void readConsole() {
    }

    @Override
    public void writeLog(byte[] buffer, int offset, int length) {

    }


    public void write(byte[] buffer, int offset, int length) {
        try {
            super.write(buffer, offset, length);
            out.write(buffer, offset, length);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void flush() {
        super.flush();
        out.flush();
    }
}
