package by.it.okatov.calc.logsystem;

import java.io.File;

public class LogSystem {


    public static String getFileName(Class<?> aClass, String fileName) {
        return System.getProperty("user.dir") +
                       File.separator +
                       "src" +
                       File.separator +
                       aClass.getName().replace(".", File.separator).
                                                                            replace(aClass.getSimpleName(), "")
                       + fileName;
    }
}
