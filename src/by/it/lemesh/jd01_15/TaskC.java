package by.it.lemesh.jd01_15;


import java.io.File;
import java.util.Scanner;

public class TaskC {
    private static String root = System.getProperty("user.dir") + File.separator + "src" + File.separator;
    private static String path = root + by.it.lemesh.jd01_15.TaskC.class.getName().replace(by.it.lemesh.jd01_15.TaskC.class.getSimpleName(), "").replace(".", File.separator);

    public static void main(String[] args) {
        String dir = "";
        Scanner sc = new Scanner(System.in);
        String line;
        while (!(line = sc.nextLine().trim()).equals("end")) {
            File f = new File(path);
            if (line.trim().equals("cd")) {
                System.out.println(path);
            } else if (line.trim().equals("cd ..")) {
                setPath();
            } else if (line.trim().equals("dir")) {
                File[] files = f.listFiles();
                assert files != null;
                for (File file : files) {
                    if (file.isDirectory()) {
                        dir = "<DIR>";
                    }
                    System.out.printf("%8s%8d %s\n", dir, file.length(), file.getName());
                    dir = "";
                }
            } else setPath(line);
        }
    }

    private static void setPath(String line) {
        String[] str = line.split(" ");
        if (str[1].contains("\\")) {
            path = str[1] + "\\";
        } else {
            path = path + str[1] + "\\";
        }
        System.out.println(path);
    }

    private static void setPath() {
        path = path.substring(0, path.length() - 2);
        int i = path.lastIndexOf('\\');
        path = path.substring(0, i + 1);
        System.out.println(path);
    }
}
