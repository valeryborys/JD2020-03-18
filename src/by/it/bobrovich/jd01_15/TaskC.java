package by.it.bobrovich.jd01_15;

import java.io.File;
import java.util.Scanner;

public class TaskC {
    private static String path = dir(TaskC.class);

    private static String dir(Class<?> cl) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String clPath = cl.getName().replace(cl.getSimpleName(), "").replace(".", File.separator);
        return path + clPath;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line;
        label:
        while (true) {
            line = sc.nextLine();
            String operation = getOperation(line);
            switch (operation) {
                case "cd ..":
                    changePath("..");
                    System.out.println(path);
                    break;
                case "cd":
                    changePath(getFlag(line));
                    System.out.println(path);
                    break;
                case "dir":
                    listFiles();
                    break;
                case "end":
                    break label;
            }
        }
    }

    private static void listFiles() {
        File file = new File(path);
        File[] fileFolders = file.listFiles();
        for (File fileFolder : fileFolders) {
            if (fileFolder.isDirectory()) {
                System.out.print("dir:" + fileFolder.getName() + "\n");
            } else {
                System.out.print("file:" + fileFolder.getName() + "\n");
            }
        }
    }

    private static String getFlag(String line) {
        return line.substring(3);
    }

    private static String getOperation(String line) {
        char[] chars = line.toCharArray();
        int end = 0;
        if(chars.length == 3 && line.equals("dir"))
            return line;
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] == ' '){
                if(chars[i+1] == '.' && chars[i+2] == '.'){
                    end = i+3;
                } else{
                    end = i;
                }
                break;
            }
        }
        return line.substring(0, end);
    }

    private static void changePath(String flag) {
        StringBuilder sb = new StringBuilder(path);
        if (flag.equals("..")) {
            for (int i = sb.length() - 2; i > -1; i--) {
                if (sb.charAt(i) == '\\') {
                    sb.delete(i, sb.length());
                    break;
                }
            }
        } else {
            sb.append("\\").append(flag).append("\\");
        }
        path = sb.toString();
    }
}
