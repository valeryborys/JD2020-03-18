package by.it.tolstik.jd01_14;

import java.io.*;
import java.util.ArrayList;

class TaskC {

    private static String pathForWriteFile(Class<?> aClass) {
        String path = System.getProperty("user.dir") + File.separator
                + "src" + File.separator;
        String cDir = aClass.getName()
                .replace(aClass.getSimpleName(), "")
                .replace(".", File.separator);
        return path + cDir;
    }

    private static ArrayList<String> listWithFileNames = new ArrayList<>();
    private static String resultDir = "";

    //@param dir = name current directory;
    private static String getPath(Class<?> aClass, String dir) {
        return System.getProperty("user.dir") + File.separator + "src" + File.separator
                + aClass.getPackageName().replace(dir, "")
                .replace(".", File.separator);
    }

    private static void getFiles(String path) {

        File file = new File(path);
        for (File elem : file.listFiles()) {
            if (elem.isFile()) {
                listWithFileNames.add(elem.getName());
            } else if (elem.isDirectory()) {
                resultDir += "dir:" + elem.getName() + "\n";
                System.out.printf("dir:%s\n", elem.getName());
                getFiles(elem.getAbsolutePath());
            }
        }

    }

    public static void main(String[] args) {
        getFiles(getPath(TaskC.class, "jd01_14"));
        try (PrintWriter pw = new PrintWriter(new FileWriter(pathForWriteFile(TaskC.class)+"resultTaskC.txt"))) {
            pw.print(resultDir);
            for (String names : listWithFileNames) {
                pw.printf("file:%s\n", names);
            }
        }
        catch (IOException e) {
            System.err.println("Ошибка " + e);
        }
        for (String names : listWithFileNames) {
            System.out.printf("file:%s\n", names);
        }
        System.out.println(TaskC.resultDir);
    }


}

