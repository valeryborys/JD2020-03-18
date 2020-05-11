package by.it.szamostyanin.Calc;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

enum  CalcLogger {
    INSTANCE;
    private static final String TIMESTAMP_PATTERN = "<dd-MM-yyyy HH:mm:ss> ";

    public void log(String text) {
        String fName = getFilename(CalcLogger.class, "log.txt");
        try (PrintWriter writer = new PrintWriter(
                new FileWriter(fName, true))
        ) {
            writer.println(getTimeStamp().concat(text));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    private String getTimeStamp() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(TIMESTAMP_PATTERN, Locale.US));
    }

    private static String getFilename(Class<?> aClass, String simpleName) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        path = path + aClass.getName().replace(".", File.separator);
        path = path.replace(aClass.getSimpleName(), "");
        return path + simpleName;
    }
}
