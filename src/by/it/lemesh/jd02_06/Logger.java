package by.it.lemesh.jd02_06;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {

    private static volatile Logger logger;

    private Logger() {
    }

    static Logger getInstance() {
        Logger log = logger;
        if (log == null) {
            synchronized (Logger.class) {
                log = logger;
                if (log == null) {
                    logger = log = new Logger();
                }
            }
        }
        return log;
    }

    private static String getDir(Class<?> cl, String name) {
        String root = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String path = cl.getName().replace(cl.getSimpleName(), "").replace(".", File.separator);
        return root + path + name;
    }

    public void log(String text) {
        SimpleDateFormat date = new SimpleDateFormat("HH:mm:ss dd.MM.yyyy");
        try (PrintWriter writer = new PrintWriter(new FileWriter(getDir(Logger.class, "log.txt"), true))) {
            text = date.format(new Date()) + " " + text;
            writer.println(text);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
