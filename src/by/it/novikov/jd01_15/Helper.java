package by.it.novikov.jd01_15;

import java.io.File;

class Helper {
    private static final String root = System.getProperty("user.dir");
    static String getPath(String fileName, Class<?> cl) {
        String name = cl.getName();
        String path = name
                .replace(cl.getSimpleName(), "")
                .replace('.', File.separatorChar);
        path = root + File.separator + "src" + File.separator + path +  fileName;
        return path;
    }
}