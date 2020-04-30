package by.it.novikov.jd01_14;

import java.io.File;

class Helper {
    private static final String root = System.getProperty("user.dir");
    static String getPath(String fileName) {
        String name = TaskA.class.getName();
        String path = name
                .replace(TaskA.class.getSimpleName(), "")
                .replace('.', File.separatorChar);
        path = root + File.separator + "src" + File.separator + path +  fileName;
        return path;
    }
}