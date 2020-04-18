package by.it.lemesh.jd01_14;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class TaskC {

    public static void main(String[] args) {
        String root = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String path = TaskC.class.getPackage().getName().replace("jd01_14", "").replace(".", File.separator);
        String path2 = TaskC.class.getName().replace(TaskC.class.getSimpleName(), "").replace(".", File.separator);
        String fileName = root + path2 + "resultTaskC.txt";

        File file = new File(root + path);
        File[] folders = file.listFiles();

        if (folders != null) {
            printConsole(folders);
            writeTxt(folders, fileName);
        }
    }

    private static void writeTxt(File[] folders, String fileName) {
        try (PrintWriter writer = new PrintWriter(fileName)) {
            for (File folder : folders) {
                if (folder.isDirectory()) {
                    writer.println("dir:" + folder.getName());
                    File[] files = folder.listFiles();
                    if (files != null) {
                        for (File f : files) {
                            writer.println("file:" + f.getName());
                        }
                    }
                } else writer.println("file:" + folder.getName());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void printConsole(File[] folders) {
        for (File folder : folders) {
            if (folder.isDirectory()) {
                System.out.println("dir:" + folder.getName());
                File[] files = folder.listFiles();
                if (files != null) {
                    for (File f : files) {
                        System.out.println("file:" + f.getName());
                    }
                }
            } else System.out.println("file:" + folder.getName());
        }
    }
}
