package by.it.verbitsky.calc;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

class CalcLogger {
    private String fName;
    private int logLinesCount;
    private static final int MAX_LINE_COUNT = 50;

    public CalcLogger(String logFileName) {
        File file = new File(logFileName);
        if (file.exists()) {
            this.fName = logFileName;
            this.logLinesCount = getLinescount(fName);
        } else {
            try {
                file.createNewFile();
                this.fName = logFileName;
                this.logLinesCount = getLinescount(fName);
            } catch (IOException e) {
                throw new NullPointerException(e.getMessage());
            }
        }

    }

    private int getLinescount(String fName) {
        //System.out.println("getLinescount " + fName);
        int linesCount = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(fName))) {
            while (reader.ready()) {
                reader.readLine();
                linesCount++;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return linesCount;
    }

    public void writeLog(String text) {
        if (logLinesCount < MAX_LINE_COUNT) {
            try {
                Files.write(Paths.get(fName), text.concat("\n").getBytes(), StandardOpenOption.APPEND);
                logLinesCount++;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            try (BufferedReader reader = new BufferedReader(new FileReader(fName))) {
                StringBuilder sb = new StringBuilder();
                //прочитали первую строку чтобы она не вошла в итоговый файл
                if (reader.ready()) {
                    reader.readLine();
                }
                while (reader.ready()) {
                    sb.append(reader.readLine()).append("\n");
                }
                sb.append(text).append("\n");
                reader.close();
                //перезаписываем файл
                try (PrintWriter writer = new PrintWriter(fName)) {
                    writer.print(sb.toString());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }


}


