package by.it.okatov.calc.logsystem;

import java.io.PrintStream;

public class LogStream extends PrintStream {
    PrintStream out;

    public LogStream(PrintStream consoleOut, PrintStream loggerOut) {
        super(consoleOut);
        this.out = loggerOut;
    }



    @Override
    public void write(byte[] buf, int off, int len) {
        try {
            super.write(buf, off, len);
            out.write(buf, off, len);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void flush() {
        super.flush();
        out.flush();
    }
}
