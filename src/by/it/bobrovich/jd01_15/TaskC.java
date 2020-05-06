package by.it.bobrovich.jd01_15;

import java.io.File;
import java.util.Scanner;

public class TaskC {

    private static String dir(Class<?> cl) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String clPath = cl.getName().replace(cl.getSimpleName(), "").replace(".", File.separator);
        return path + clPath;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();

        while (true) {
            if(line.equals("end")){
                break;
            }
            if(line.equals("dir")){
                listFiles();
            } else if(line.equals("cd")){

            }
        }
    }

    private static void listFiles() {

    }
}
