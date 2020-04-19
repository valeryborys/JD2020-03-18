package by.it.tolstik.jd01_14;

import java.io.*;
import java.util.ArrayList;

class TaskC {

    private static final ArrayList<String> listWithFileNames = new ArrayList<>();
    private static String resultDir = "";

    public static void main(String[] args) {
        getListFilesAndDir(getPath(TaskC.class, "jd01_14"));
        recordInFile("resultTaskC.txt");
        printFilesToConsole();
        System.out.println(TaskC.resultDir);
    }

    //@param dir = name current directory for printing by step up in your directory;
    private static String getPath(Class<?> aClass, String dir) {
        return System.getProperty("user.dir") + File.separator + "src" + File.separator
                + aClass.getPackageName().replace(dir, "")
                .replace(".", File.separator);
    }

    private static void getListFilesAndDir(String path) {
        File file = new File(path);
        for (File elem : file.listFiles()) {
            if (elem.isFile()) {
                listWithFileNames.add(elem.getName());
            } else if (elem.isDirectory()) {
                resultDir += "dir:" + elem.getName() + "\n";
                getListFilesAndDir(elem.getAbsolutePath());
            }
        }
    }

    private static String pathForWriteFile(Class<?> aClass) {
        String path = System.getProperty("user.dir") + File.separator
                + "src" + File.separator;
        String cDir = aClass.getName()
                .replace(aClass.getSimpleName(), "")
                .replace(".", File.separator);
        return path + cDir;
    }

    private static void printFilesToConsole() {
        for (String names : listWithFileNames) {
            System.out.printf("file:%s\n", names);
        }
    }

    private static void recordInFile(String name) {
        try (PrintWriter pw = new PrintWriter
                (new FileWriter(pathForWriteFile(TaskC.class) + name))) {
            pw.print(resultDir);
            for (String names : listWithFileNames) {
                pw.printf("file:%s\n", names);
            }
        } catch (IOException e) {
            System.err.println("Ошибка " + e);
        }
    }
}

