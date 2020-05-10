package by.it.novikov.jd01_14;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

class TaskC {
    public static void main(String[] args) {
        File file = new File(System.getProperty("user.dir") + File.separator
                + "src" + File.separator + "by" + File.separator + "it" + File.separator
                   + "novikov" + File.separator);
        File [] myFiles = file.listFiles();
        getFiles(myFiles);
        System.out.println(file);
    }

    private static void getFiles (File[] directory){
        try{
        for (File file : directory) {
            if (file.isDirectory()){
                String printable = "dir:" + file.getName();
                System.out.println(printable);
                writeToFile(printable);
                getFiles(file.listFiles());
            }
            else {
                String printable = "file:" + file.getName();
                System.out.println(printable);
                writeToFile(printable + "\n");
            }
        }}
        catch (NullPointerException e){
            System.out.println("Список пуст");
        }
    }

    private static void writeToFile(String text) {
        File file = new File(getPath());
        try (FileWriter fw = new FileWriter(file, true)) {
            fw.write(text + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static String getPath() {
        String name = TaskC.class.getName();
        String path = name
                .replace(TaskC.class.getSimpleName(), "")
                .replace('.', File.separatorChar);
        path = System.getProperty("user.dir") + File.separator
                + "src" + File.separator + path + "resultTaskC.txt";
        return path;
    }
}