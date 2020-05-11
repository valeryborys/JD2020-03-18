package by.it.lemesh.calc;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.stream.Stream;

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
        long countLines = 0;
        String fileName = getDir(Logger.class, "log.txt");
        text = date.format(new Date()) + " " + text;

        try (Stream<String> lines = Files.lines(Paths.get(fileName))) {
            countLines = lines.count();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (countLines == 50) {
            StringBuilder sb = new StringBuilder();
            try (BufferedReader bf = new BufferedReader(new FileReader(fileName))) {
                bf.readLine();
                for (long i = 1; i < 50; i++) {
                    sb.append(bf.readLine()).append("\n");
                }
                sb.append(text);
            } catch (IOException e) {
                e.printStackTrace();
            }

            try (FileOutputStream fos = new FileOutputStream(fileName)) {
                fos.write(sb.toString().getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try (BufferedWriter bf = new BufferedWriter(new FileWriter(fileName, true))) {
                bf.newLine();
                bf.write(text);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
