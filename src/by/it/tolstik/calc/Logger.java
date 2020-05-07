package by.it.tolstik.calc;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;

class Logger {
    private static final Queue<String> logList = new ArrayDeque<>();

    void logger(String line) {

        String logFile = Printer.getFile("log.txt");
        File log = new File(logFile);
        int count = 0;
        if(log.exists()){

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(log)))) {
                while (reader.ready()){
                    logList.add(reader.readLine());
                    count++;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        logList.add(line);
        while (count > 49){
            logList.poll();
            count--;
        }

        try (PrintWriter writerLog = new PrintWriter(logFile)){
            while (!logList.isEmpty()) {
                writerLog.println(logList.poll());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }


}