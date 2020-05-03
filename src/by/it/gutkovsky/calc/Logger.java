package by.it.gutkovsky.calc;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

class Logger {

    void logger(String line) {
        String logFile = Printer.getFile("log.txt");
        try (PrintWriter writerLog = new PrintWriter(logFile)){
            writerLog.println(line+"\n");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }


}
