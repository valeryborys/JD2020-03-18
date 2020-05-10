package by.it.okatov.calc.logsystem;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class LogSystem {

    private static final String filename = "Debug.log";
    private static String FULL_PATH_TO_LOG = "";

    public static String getFullPathToLog() {
        return FULL_PATH_TO_LOG;
    }

    public static void setFullPathToLog(String fullPathToLog) {
        FULL_PATH_TO_LOG = fullPathToLog;
    }

    private static LogSystem logger;

    public static LogSystem getInstance() {
        LogSystem localLogger = LogSystem.logger;
        if (localLogger == null) {
            synchronized (LogSystem.class) {
                localLogger = LogSystem.logger;
                if (localLogger == null) {
                    LogSystem.logger = localLogger = new LogSystem();
                }
            }
        }

        return localLogger;
    }

    public void createLog(String text) {
        try (
                PrintWriter writer = new PrintWriter(
                        new FileWriter(
                                getFileName(LogSystem.class, filename), true
                        )
                )
        ) {
            DateFormat df = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.MEDIUM, Locale.getDefault());
            Date date = new Date();
            writer.printf("%s: %s%n", df.format(date), text);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public enum MODE {
        INPUT,
        OUTPUT
    }


    public void createLog(String text, MODE mode) {

        try (
                PrintWriter writer = new PrintWriter(
                        new FileWriter(
                                getFileName(LogSystem.class, filename), true
                        )
                )
        ) {
            DateFormat df = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.MEDIUM, Locale.getDefault());
            Date date = new Date();
            switch (mode) {
                case INPUT:
                    writer.printf("%s: %s %s%n", df.format(date), "SYSTEM.INPUT: ", text);
                    break;
                case OUTPUT:
                    writer.printf("%s: %s%n", df.format(date), text);
                    break;
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getFileName(Class<?> aClass, String fileName) {
        setFullPathToLog(System.getProperty("user.dir") +
                                 File.separator +
                                 "src" +
                                 File.separator +
                                 aClass.getName().replace(".", File.separator).
                                                                                      replace(aClass.getSimpleName(), "")
                                 + fileName);
        return System.getProperty("user.dir") +
                       File.separator +
                       "src" +
                       File.separator +
                       aClass.getName().replace(".", File.separator).
                                                                            replace(aClass.getSimpleName(), "")
                       + fileName;
    }
}
