package by.it.borys.jd02_06;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

//правильнее Singleton делать чере enum
public class Logger {
    private final String fileName = "log.txt";
    private static volatile Logger logger;
    private Logger(){

    }

    static Logger getInstance(){
        Logger localLogger = Logger.logger;
        if(logger==null) {
            synchronized (Logger.class) {
                localLogger = Logger.logger;
                if (logger==null){
                logger =localLogger= new Logger();
                }
            }
        }
        return localLogger;

    }

    private static String getFilename(Class<?> aClass, String simpleName) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        path = path + aClass.getName().replace(".", File.separator);
        path = path.replace(aClass.getSimpleName(), "");
        return path + simpleName;
    }

    public void log(String text) {
        try ( PrintWriter printWriter = new PrintWriter(new FileWriter(getFilename(Logger.class, fileName),true))){
            printWriter.print(text);
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
            printWriter.println(" - "+sdf.format(new Date()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
