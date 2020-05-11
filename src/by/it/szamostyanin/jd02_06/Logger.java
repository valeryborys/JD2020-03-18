package by.it.szamostyanin.jd02_06;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

/*enum Logger {   //правильный метод
    GET;*/

class Logger {    //метод учебный, ориентирован на понимание
    private final String filename = "log.txt";
    private static volatile Logger logger;   //volatile для многопоточки

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


    public void log(String text) {
        try
                (PrintWriter printWriter = new PrintWriter(new FileWriter(getFileName(Logger.class, filename), true))) {
            printWriter.print(LocalDateTime.now().format(DateTimeFormatter.ofPattern("<dd-MM-yyyy HH:mm:ss> ")));
            printWriter.println(text);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String getFileName(Class<?> aClass, String aName) {
        String path = aClass.getName().replace(".", "\\");
        String root = System.getProperty("user.dir") + "\\" + "src" + File.separator;   //File.separator - "\" в windows
        path = path.replace(aClass.getSimpleName(), "");
        return root + path + aName;
    }
}
