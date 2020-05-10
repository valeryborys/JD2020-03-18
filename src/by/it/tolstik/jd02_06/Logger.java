package by.it.tolstik.jd02_06;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;

class Logger {

    Calendar calendar = new GregorianCalendar();
    private final String fileName = "log.txt";
    private static volatile Logger logger;

    private Logger() {
    }

    static Logger getInstance() {
        Logger localLogger = Logger.logger;
        if (localLogger == null) {
            synchronized (Logger.class) {
                localLogger = Logger.logger;
                if (localLogger == null) {
                    logger = localLogger = new Logger();
                }
            }
        }
        return localLogger;
    }


    private static String getFileName(Class<?> aClass, String fileName) {
        String path = System.getProperty("user.dir") + File.separator
                + "src" + File.separator;
        String cDir = aClass.getName().replace(aClass.getSimpleName(), "")
                .replace(".", File.separator);
        return path + cDir + fileName;
    }

    public void log(String text) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(getFileName(Logger.class, fileName), true))) {
            pw.println(text + calendar.getTime());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
