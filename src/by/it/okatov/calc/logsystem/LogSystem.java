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

    public static String getFileName(Class<?> aClass, String fileName) {
        return System.getProperty("user.dir") +
                       File.separator +
                       "src" +
                       File.separator +
                       aClass.getName().replace(".", File.separator).
                                                                            replace(aClass.getSimpleName(), "")
                       + fileName;
    }
}
