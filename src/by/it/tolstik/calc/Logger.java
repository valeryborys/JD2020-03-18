package by.it.tolstik.calc;

import java.io.*;
import java.util.*;

class Logger {

    private static volatile Logger logger;
    private static final Queue<String> logList = new ArrayDeque<>();

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

    void log(String line) {

        String logFile = Util.getFile("log.txt");
        File log = new File(logFile);
        int count = 0;
        if (log.exists()) {

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(log)))) {
                while (reader.ready()) {
                    logList.add(reader.readLine());
                    count++;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Calendar calendar = new GregorianCalendar();
        String event = line + " : " + calendar.getTime();

        logList.add(event);
        while (count > 49) {
            logList.poll();
            count--;
        }

        try (PrintWriter writerLog = new PrintWriter(logFile)) {
            while (!logList.isEmpty()) {
                writerLog.println(logList.poll());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


}