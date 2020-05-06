package by.it.bobrovich.jd01_15;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class TaskB {
    static List<String> listOfFile;
//1line one

    /**
     *
     * @param cl
     * @return
     */
    private static String dir(Class<?> cl) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String clPath = cl.getName().replace(cl.getSimpleName(), "").replace(".", File.separator);
        return path + clPath;
    }
/*
multiline
 */
    public static void main(String[] args) {
//oneline two

        try (PrintWriter pw = new PrintWriter(
                new FileWriter(
                        dir(TaskB.class) + "TaskB.txt")
                )
        ){
           listOfFile = Files.readAllLines(Paths.get(dir(TaskB.class) + "TaskB.java"));
           pw.print(removeComments(listOfFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
/*
multiline two
 */
    }

    private static String removeComments(List<String> listOfFile) {
        String str = "\n";
        StringBuilder sb = new StringBuilder();
        for (String s : listOfFile) {
            sb.append(s).append("\n");
        }
        for (int i = 0; i < sb.length(); i++) {
            if(sb.charAt(i) == 47){
                if(sb.charAt(i+1) == 47){
                    for (int j = i+2; j < sb.length(); j++) {
                        if(sb.charAt(j) == str.toCharArray()[0]){
                            sb.delete(i,j);
                            break;
                        }
                    }
                } else{
                    for (int j = i+1; j < sb.length(); j++) {
                        if(sb.charAt(j) == 47){
                            sb.delete(i,j+1);
                            break;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < sb.length(); i++) {
            System.out.print(sb.charAt(i));
        }
        return sb.toString();
    }
}
