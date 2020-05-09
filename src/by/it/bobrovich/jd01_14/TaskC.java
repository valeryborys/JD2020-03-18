package by.it.bobrovich.jd01_14;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TaskC {

    private static String dir(Class<?> cl) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String clPath = cl.getName().replace(cl.getSimpleName(), "")
                .replace("jd01_14.", "")
                .replace(".", File.separator);
        return path + clPath;
    }

    public static void main(String[] args) {
        File file = new File(dir(TaskC.class));
        listFiles(file);
    }

    private static void listFiles(File file) {
        try(PrintWriter pw = new PrintWriter(new FileWriter(dir(TaskA.class) + "jd01_14" + File.separator +"resultTaskC.txt"))
        ){
            File[] fileFolders = file.listFiles();
            for (File fileFolder : fileFolders) {
                if (fileFolder.isDirectory()) {
                    System.out.print("dir:" + fileFolder.getName() + "\n");
                    pw.print("dir:" + fileFolder.getName() + "\n");
                    listFiles(fileFolder);
                    continue;
                } else {
                    System.out.print("file:" + fileFolder.getName() + "\n");
                    pw.print("file:" + fileFolder.getName() + "\n");
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
