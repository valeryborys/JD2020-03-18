package by.it.tolstik.calc;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.GregorianCalendar;

class LoggerOfExceptions {

    private static volatile LoggerOfExceptions logger;

    private LoggerOfExceptions() {
    }

    static LoggerOfExceptions getInstance() {
        LoggerOfExceptions localLogger = LoggerOfExceptions.logger;
        if (localLogger == null) {
            synchronized (LoggerOfExceptions.class) {
                localLogger = LoggerOfExceptions.logger;
                if (localLogger == null) {
                    logger = localLogger = new LoggerOfExceptions();
                }
            }
        }
        return localLogger;
    }

    public void log(String text) {
        String fn = Util.getFile("logExceptions.txt");
        GregorianCalendar calendar = new GregorianCalendar();

        try (PrintWriter printWriter = new PrintWriter(
                new FileWriter(fn, true))) {
            printWriter.println(text + " " + calendar.getTime());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}