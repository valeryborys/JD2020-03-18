package by.it.borys.jd01_14;

import by.it.borys.Main;

import java.io.*;

public class TaskC {
    public static void main(String[] args) {
        File file = new File(TaskA.dir(Main.class));
        try {
            new FileWriter(TaskA.dir(TaskC.class) + "resultTaskC.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        getFilesAndDir(file);
    }

    private static void getFilesAndDir(File file) {
              if (file.isDirectory()) {
                  File[] files = file.listFiles();
                  for (File file1 : files) {
                      getFilesAndDir(file1);
                  }
                  System.out.println("dir:" + file.getName());
                  printToTxt("dir:" + file.getName());
                } else {
                System.out.println("file:" + file.getName());
                printToTxt("file:" + file.getName());
               }
    }
   private static void printToTxt(String str) {
        try (PrintWriter out = new PrintWriter(new FileWriter(TaskA.dir(TaskC.class) + "resultTaskC.txt",true))) {
              out.println(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
   }
    }

